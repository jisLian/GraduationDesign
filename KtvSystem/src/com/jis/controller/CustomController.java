package com.jis.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
/**
 * �˿Ͳ���������
 * @author shu
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jis.form.OrderRoomForm;
import com.jis.pojo.Customer;
import com.jis.pojo.Employee;
import com.jis.pojo.Goods;
import com.jis.pojo.GoodsType;
import com.jis.pojo.Room;
import com.jis.pojo.RoomGoods;
import com.jis.pojo.RoomRecord;
import com.jis.pojo.RoomType;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.Vip;
import com.jis.service.CustomerService;
import com.jis.service.EmpService;
import com.jis.util.DateUtil;
import com.jis.util.Token;
@Controller
@SessionAttributes("loginUser")
public class CustomController {
	@Autowired
	private CustomerService customer;
	@Autowired
	private EmpService empService;
	
	/**
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping("login")
	public String login(){
		return "page/login";
	}
	/**
	 * ajaxУ���û���
	 * @return
	 */
	@ResponseBody
	@RequestMapping("validate_userName")
	public String validate_userName(String userName){
		int Name=0;
		Vip vip=null;
		Employee emp=null;
		try {
			Name=Integer.parseInt(userName);
			emp=empService.findEmpByempId(Name);
		} catch (NumberFormatException e) {
			vip=customer.findVipByVipTel(userName);			
		}				
		if(vip!=null||emp!=null){
			return "";
		}
		else{
			return "�û������ڣ�";
		}
	}
	/**
	 * �ύ��¼����֤
	 * @param userName
	 * @param pwd
	 * @return
	 */
	@RequestMapping("login_validate")
	public String login_validate(String userName,String pwd,ModelMap map){
		int Name=0;
		Vip vip=null;
		Employee emp=null;
		try {
			Name=Integer.parseInt(userName);
			emp=empService.findEmpByempId(Name);
		} catch (NumberFormatException e) {
			vip=customer.findVipByVipTel(userName);			
		}	
		if(vip!=null){
			if(vip.getVipPwd().equals(pwd)){
				//VIP�û���¼��¼�ɹ�����ת��ҳ��
				map.put("loginUser", vip);
				return "page/VIP";
			}
			
		}
		else if(emp!=null){
			if(emp.getEmpPwd().equals(pwd)){
				//���ֹ���Ա����ͨԱ����0�Ƿ���Ա 1��ǰ̨Ա��2�ǹ���Ա��
				map.put("loginUser", emp);
				if(emp.getEmpFlag()==0){
					//����Ա��¼�ɹ�����ת��ҳ��					
					return "page/waiter";
				}else if(emp.getEmpFlag()==2){
					//����Ա��¼�ɹ�����ת��ҳ��
					return "page/admin";
				}else{
					//ǰ̨��Ա��ת��ҳ��
					return "redirect:showRoom.do";
				}				
			}
		}
		else{
			map.put("pwdError","�������");
		}
		return "page/login";
	}
	@RequestMapping("showRoom")
	public String showRoom(OrderRoomForm orderRoomForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//��ȡ��������
		List<RoomType> list=empService.findAllRoomType();
		//�����з�������д������
		req.setAttribute("roomTypeList", list);
		//��ȡ���ƣ���ˢ�£�
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=orderRoomForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//Ԥ������
		if(orderRoomForm!=null&&serverToken!=null&&serverToken.toString().equals(token)){
			System.out.println("���������"+serverToken.toString());			
			float fee=Float.parseFloat(orderRoomForm.getMoney());
			int hours=Integer.parseInt(orderRoomForm.getOrderTime());			
			Vip vip = empService.findVipByVipTel(orderRoomForm.getVipTel());	
			Customer customer=empService.findCustomerByTel(orderRoomForm.getVipTel());
			if(vip!=null){
				if(!vip.getVipName().equals(orderRoomForm.getVipName())){
					empService.updateName(orderRoomForm.getVipName(),vip.getVipId());
				}
				//���ѳ���500����ӻ�Ա�ȼ�
				if(fee>500){
					empService.AddVipLevel(vip.getVipId());
				}
				RoomRecord record=new RoomRecord(orderRoomForm.getSelectedRoom(),DateUtil.getNowDate(),DateUtil.getAfterDate(DateUtil.getNowDate(),hours),null,vip.getVipId(),fee);
				//��ӷ���ʹ�ü�¼
				empService.AddRecord(record);
				//�޸�Ԥ������ʹ�ñ�ʶ
				empService.updateRoomUseFlag(orderRoomForm.getSelectedRoom());
				str="Ԥ���ɹ�";
				req.setAttribute("RegSuccess",str);
			}else if(customer!=null){
				//�����ͻ��Ѵ��ڣ����Ƿ���Ҫ�޸��û���
				if(!customer.getCustomerName().equals(orderRoomForm.getVipName())){
					empService.updateName(orderRoomForm.getVipName(), customer.getCustomerId());
				}
				RoomRecord record=new RoomRecord(orderRoomForm.getSelectedRoom(),DateUtil.getNowDate(),DateUtil.getAfterDate(DateUtil.getNowDate(),hours),null,customer.getCustomerId(),fee);
				empService.AddRecord(record);
				empService.updateRoomUseFlag(orderRoomForm.getSelectedRoom());
				str="�ύ�ɹ�";
				req.setAttribute("RegSuccess",str);
			}else{
				//�¿ͻ�����ӿͻ���Ϣ
				Customer c=new Customer(orderRoomForm.getVipName(),orderRoomForm.getVipTel());
				empService.AddCustomer(c);					
				Customer cus=empService.findCustomerByTel(orderRoomForm.getVipTel());
				System.out.println("���û�������"+orderRoomForm.getVipName());
				RoomRecord record=new RoomRecord(orderRoomForm.getSelectedRoom(),DateUtil.getNowDate(),DateUtil.getAfterDate(DateUtil.getNowDate(),hours),null,cus.getCustomerId(),fee);				
				empService.AddRecord(record);
				empService.updateRoomUseFlag(orderRoomForm.getSelectedRoom());
				str="�ύ�ɹ�";
				req.setAttribute("RegSuccess",str);
			}
			
		}
		
		return "page/frontEmp";
	}
	/**
	 * ���������Ϣ����ҳ
	 * @param vipId
	 * @return
	 */
	@RequestMapping("vipInfo")
	public String vipInfo(int vipId){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();		
		Vip vip=customer.findVipByVipId(vipId);
		req.setAttribute("vip", vip);
		return "page/vipInfo";
	}
	/**
	 * ����Vip����
	 * @return
	 */
	@RequestMapping("inVip")
	public String inVip(){
		return "page/VIP";
	}
	/**
	 * ������Ʒ
	 * @param typeId
	 * @param pageCode
	 * @return
	 */
	@RequestMapping("BuyGoods")
	public String BuyGood(int typeId,int pageCode,String roomId){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<GoodsType> goodTypeList=customer.findGoodsTypes();
		List<Goods> newList=new ArrayList<Goods>();
		HttpSession session=request.getSession();
		List<Goods>	foodList=(ArrayList<Goods>)session.getAttribute("foodList");
		List<Goods> goodsList=null;
		//����Ŀ��
		int tatalItems=0;
		//��ҳ����
		int sumPage=1;
		if(typeId==0){
			goodsList=customer.findAllGoods(pageCode);
			tatalItems=customer.findAllGoodsCount();
		}else{
			goodsList=customer.findGoodsByTypeId(typeId, pageCode);
			tatalItems=customer.findGoodsCountByTypeId(typeId);
		}	
		if(tatalItems%10==0){
			sumPage=tatalItems/10;
		}else{
			sumPage=tatalItems/10+1;
		}
		String buyCount;
		if(session.getAttribute("buyCount")!=null){
			buyCount=session.getAttribute("buyCount").toString();
		}
		else{
			buyCount="0";
		}
		request.setAttribute("buyCount",buyCount );
		if(foodList!=null){
			for(int i=0;i<foodList.size();i++){
				for(int j=0;j<goodsList.size();j++){
					if(foodList.get(i).getGoodsId()==goodsList.get(j).getGoodsId()){
						newList.add(foodList.get(i));
					}
				}
			}
			
		}
		System.out.println("newList"+newList.size());
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("currentPage", pageCode);
		request.setAttribute("typeId", typeId);
		request.setAttribute("goodTypeList", goodTypeList);
		request.setAttribute("goodsList", goodsList);
		session.setAttribute("roomId", roomId);
		request.setAttribute("newList", newList);
		return "page/buyGoods";
	}
	/**
	 * �����޸�����ҳ��
	 * @return
	 */
	@RequestMapping("updatepwd")
	public String updatepwd(){		
		return "page/updatePassword";
	}
	/**
	 * ����ԭ����
	 * @param vipId
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryPwd")
	public String queryPwd(int vipId,String pwd){
		Vip vip=customer.findVipByVipId(vipId);
		if(vip.getVipPwd().equals(pwd)){
			return "";
		}
		System.out.println(pwd);
		return "�������";
	}
	/**
	 * �޸�����
	 * @param vipId
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateNewPwd")
	public String updateNewPwd(int vipId,String pwd){
		customer.updtatePwd(vipId, pwd);
		return "�����޸ĳɹ���";
	}
	/**
	 * ���ҷ���
	 */
	@ResponseBody
	@RequestMapping("queryRoom")
	public String queryRoom(String roomId){
		Room room=customer.findRoomByroomId(roomId);
		if(room!=null){
			return "";
		}
		return "�������Ч��";
	}
	/**
	 * ������Ʒ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("AjaxBuyFood")
	public String AjaxBuyFood(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();
		List<Goods>	foodList=(ArrayList<Goods>)session.getAttribute("foodList");
		int fcount=Integer.parseInt(request.getParameter("count"));
		//��������д��session��
		String buyCount=request.getParameter("buycount");
		session.setAttribute("buyCount", buyCount);
		String foodIdStr=request.getParameter("foodId");
		int foodId=-1;
		if(foodIdStr!=""){
			foodId=Integer.parseInt(foodIdStr);
		}
						
		boolean flag=false;
		if(foodList!=null){
			for(Goods food:foodList){
				if(food.getGoodsId()==foodId){
					food.setGoodscount(fcount);
					flag=true;
				}
			}
		}
		else{
			foodList=new ArrayList<Goods>();
		}		
		if(!flag){
			foodList.add(new Goods(foodId,fcount));
		}
		session.setAttribute("foodList", foodList);
		return "";
	}
	/**
	 * ��������
	 * @return
	 */
	@ResponseBody
	@RequestMapping("AjaxCountFoods")
	public String AjaxCountFoods(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();
		List<Goods>	foodList=(ArrayList<Goods>)session.getAttribute("foodList");
		String roomId=(String)session.getAttribute("roomId");
		if(foodList!=null&&foodList.size()!=0){
			for(Goods food:foodList){
				customer.addFoodToRoom(new RoomGoods(roomId, food.getGoodsId(), food.getGoodscount(),new Date()));
			}
		}
		float sumPrice=customer.countGoodsFee(roomId);
		session.removeAttribute("foodList");
		return sumPrice+"";
	}
	/**
	 * Ԥ������
	 * @return
	 */
	@RequestMapping("orderRoom")
	public String orderRoom(){
		List<RoomType> roomTypeList=empService.findAllRoomType();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("roomTypeList", roomTypeList);
		List<Room> roomList=empService.findEmptyRoomById(roomTypeList.get(0).getRoomTypeId());
		request.setAttribute("roomList", roomList);
		return "page/orderRoom";
	}
	/**
	 * ���ݰ�������ͱ�Ų��Ұ���
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findRoom")
	public List<Room> findRoom(String roomTypeId){
		List<Room> roomList=empService.findEmptyRoomById(Integer.parseInt(roomTypeId));
		return roomList;
	}
	@RequestMapping("submitRoom")
	public String submitRoom(String roomId,String orderDate,int hours,float roomFee,int vipId){
		Date startTime=null;
		Date endTime=null;
		if(hours==6){
			startTime=DateUtil.parseRoomDate(orderDate+" "+"12:00");
			endTime=DateUtil.parseRoomDate(orderDate+" "+"18:00");
		}else if(hours==7){
			startTime=DateUtil.parseRoomDate(orderDate+" "+"19:00");
			endTime=DateUtil.parseRoomDate(orderDate+" "+"02:00");
		}		
		RoomRecord record=new RoomRecord(roomId,startTime,endTime,null,vipId,roomFee);
		empService.AddRecord(record);
		//�޸�Ԥ������ʹ�ñ�ʶ
		empService.updateRoomUseFlag(roomId);
		return "redirect:orderRoom.do";
	}
	/**
	 * ����vipϵͳ֪ͨҳ��
	 * @return
	 */
	@RequestMapping("intoVipSystemInfo")
	public String intoVipSystemInfo(String tel,int flag){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<SystemInfo> infoList=customer.findinfo(tel, flag);
		request.setAttribute("infoList", infoList);
		System.out.println(infoList.size());
		return "page/vipSystemInfo";
	}
	@ResponseBody
	@RequestMapping("VipSystemInfo")
	public List<SystemInfo> VipSystemInfo(String tel,int flag){
		List<SystemInfo> infoList=customer.findinfo(tel, flag);
		return infoList;
	}
	
}
