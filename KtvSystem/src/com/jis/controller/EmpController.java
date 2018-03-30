package com.jis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.jis.bean.GoodsInfo;
import com.jis.bean.RoomGoodsList;
import com.jis.form.ExitRoomForm;
import com.jis.form.RegistVipForm;
import com.jis.form.RenewRoomForm;
import com.jis.pojo.Customer;
import com.jis.pojo.Goods;
import com.jis.pojo.Room;
import com.jis.pojo.RoomGoods;
import com.jis.pojo.RoomRecord;
import com.jis.pojo.RoomType;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.Vip;
import com.jis.service.EmpService;
import com.jis.util.DateUtil;
import com.jis.util.Token;

/**
 * ��ͨԱ��������
 * @author shu
 *
 */
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	/**
	 * ��ת����̨��ǰ̨��Ա��ҳ��
	 * @return
	 */
	@RequestMapping("frontEmp")
	public String jumpFrontEmp(){
		return "page/frontEmp";
	}
	/**
	 * ���ҿհ���
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("EmptyRoom")
	public List<Room> EmptyRoom(int roomTypeId){
		return empService.findEmptyRoomById(roomTypeId);
	}
	/**
	 * ��ȡ����۸�
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("price")
	public String price(int roomTypeId){
		//���ݷ����Ų��ҷ�������
		RoomType roomType=empService.findRoomTypeById(roomTypeId);
		float disCount=1;		
		if(roomType!=null){
			//��ȡÿ��ʱ��ļ۸�
			int perFee=roomType.getPerFee();
			return perFee+"";
			//��ȡʱ��η���
			/*TimeFee timeFee= empService.findFee();
			if(timeFee!=null){
				//��ȡ�������͵��ۿۼ�
				AddPrice discount=empService.findDisById(roomTypeId, timeFee.getTimeId());
				disCount=discount.getDiscountPrice();
			}
		
			return new Float(disCount*perFee).toString();*/
		}
		return null;
	}
	/**
	 * ��ѯ��ʹ�õİ����
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("HasUseRoom")
	public List<Room> HasUseRoom(int roomTypeId){
		return empService.findHasUseRoomById(roomTypeId);
	}
	/**
	 * �����û��ĵ绰�����û�
	 * @param userTel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("RegTest")
	public String RegTest(String userTel){
		Vip vip = empService.findVipByVipTel(userTel);
		if(vip!=null){
			return vip.getVipTel()+"/"+vip.getVipDiscount();
		}
		return null;
	}
	/**
	 * ��ѯ�˿͵ĵ绰����
	 * @param roomId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("vipTel")
	public String vipTel(String roomId){
		RoomRecord record = empService.findCustomerIdByRoomId(roomId);
		if(record!=null){
			int cid=record.getCustomerId();
			Customer c=empService.findCustomerById(cid);		
			Vip vip = empService.findVipByVipTel(c.getCustomerTel());
			if(vip!=null){
				return vip.getVipTel()+"/"+vip.getVipDiscount();
			}else{
				return c.getCustomerTel()+"/1";
			}
		}
		return "";
	}
	/**
	 * �˷���ʼ��
	 * @param roomId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("exitRoom")
	public JSONObject exitRoom(String roomId){
		RoomRecord record = empService.findCustomerIdByRoomId(roomId);
		int cid=record.getCustomerId();
		Customer c=empService.findCustomerById(cid);	
		Vip vip = empService.findVipByVipTel(c.getCustomerTel());		
		float discount=1;		
		if(vip!=null){
			discount=vip.getVipDiscount();
		}
		//����JSON����
		JSONObject json = new JSONObject();
		Date date=new Date();
		date.setMinutes(date.getMinutes()+5);
		
		int overTime=0;
		if(DateUtil.betweenTimeScale(record.getStartTime(), record.getEndTime(), date)==false){
			overTime=DateUtil.getHoursBetweenTime( date,record.getEndTime());
		}	
		System.out.println(discount);
		System.out.println(overTime);
		json.put("vipTel", c.getCustomerTel());
		json.put("startTime", DateUtil.DataToString("yyyy-MM-dd HH:mm", record.getStartTime()));
		json.put("endTime", DateUtil.DataToString("yyyy-MM-dd HH:mm", record.getEndTime()));
		json.put("discount", discount);
		json.put("overTime", overTime);
		
		return json;
	}
	/**
	 * �����������
	 * @param renewRoomForm
	 * @return
	 */
	@RequestMapping("renewRoom")
	public String renewRoom(RenewRoomForm renewRoomForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//��ȡ��������
		List<RoomType> list=empService.findAllRoomType();
		//�����з�������д������
		req.setAttribute("roomTypeList", list);
		//��ȡ���ƣ���ˢ�£�
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=renewRoomForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//���Ѳ���
		if(renewRoomForm!=null&&serverToken!=null&&serverToken.toString().equals(token)){
			RoomRecord record = empService.findCustomerIdByRoomId(renewRoomForm.getContinueRoom());
			Date date=record.getEndTime();
			int hour=Integer.parseInt(renewRoomForm.getContinueTime());
			float fee=Float.parseFloat(renewRoomForm.getConMoney());
			record.setCunsumFee(record.getCunsumFee()+fee);
			Vip vip = empService.findVipByVipTel(renewRoomForm.getConVipTel());			
			if(vip!=null&&fee>500){
				empService.AddVipLevel(vip.getVipId());
			}
			record.setEndTime(DateUtil.getAfterDate(date, hour));
			empService.updateRoomRecord(record);
			str="���ѳɹ���";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	/**
	 * ע���Ա����
	 * @param registVip
	 * @return
	 */
	@RequestMapping("regVip")
	public String regVip(RegistVipForm registVip){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//��ȡ��������
		List<RoomType> list=empService.findAllRoomType();
		//�����з�������д������
		req.setAttribute("roomTypeList", list);
		//��ȡ���ƣ���ˢ�£�
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=registVip.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//ע���Ա
		if(registVip!=null&&serverToken!=null&&serverToken.toString().equals(token)){			
			Customer c=empService.findCustomerByTel(registVip.getRegTel());
			//���˻�Աû�пͻ���¼�������
			if(c==null){
				Customer customer=new Customer(registVip.getRegName(),registVip.getRegTel());
				empService.AddCustomer(customer);
			}
			//���ҿͻ��õ�id
			Customer Newcustomer=empService.findCustomerByTel(registVip.getRegTel());
			Vip v=new Vip(Newcustomer.getCustomerId(),Newcustomer.getCustomerName(),Newcustomer.getCustomerTel(),registVip.getBirthday(),registVip.getVipSex());
			//��ӻ�Ա
			empService.AddVip(v);	
			str="ע��ɹ�";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	
	/**
	 * �˷�����
	 * @param exitRoomForm
	 * @return
	 */
	@RequestMapping("showExitRoom")
	public String exitRoom(ExitRoomForm exitRoomForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//��ȡ��������
		List<RoomType> list=empService.findAllRoomType();
		//�����з�������д������
		req.setAttribute("roomTypeList", list);
		//��ȡ���ƣ���ˢ�£�
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=exitRoomForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//�˷�����
		if(exitRoomForm!=null&&serverToken!=null&&serverToken.toString().equals(token)){
			RoomRecord record = empService.findCustomerIdByRoomId(exitRoomForm.getExitRoomId());
			Date date=new Date();
			float fee=Float.parseFloat(exitRoomForm.getExitMoney());
			Vip vip = empService.findVipByVipTel(exitRoomForm.getExitVipTel());			
			if(vip!=null&&fee>500){
				empService.AddVipLevel(vip.getVipId());
			}
			record.setActualEndTime(date);
			record.setCunsumFee(record.getCunsumFee()+fee);
			empService.exitRoomRecord(record);
			empService.updateRoomExitFlag(exitRoomForm.getExitRoomId());
			str="�˷��ɹ���";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	@RequestMapping("foodList")
	public String foodLst(String roomId){
		//�������еĶ���ʳ��ķ���
		List<Room> list = empService.findGoodsRoomByRoomId();
		//��󼯺ϵ���
		List<RoomGoodsList> roomGoodsList=new ArrayList<>(); 
		for(Room room : list){			
			List<Goods> fdList=empService.findGoodsBygoodsId(room.getRoomId());
			
			List<GoodsInfo> goodsInfoList=new ArrayList<GoodsInfo>();
			for(Goods goods:fdList){	
				
				List<RoomGoods> rd=empService.findCountById(room.getRoomId(), goods.getGoodsId());
				if(rd.size()!=0){
					for(int i=0;i<rd.size();i++){
						GoodsInfo goodsInfo=new GoodsInfo(goods.getGoodsId(),rd.get(i).getOrderCount(),goods.getGoodsName());
						goodsInfoList.add(goodsInfo);
					}
					
				}
			}
			RoomGoodsList rfList=new RoomGoodsList(room.getRoomId(),goodsInfoList);
			roomGoodsList.add(rfList);
		}
		String str="";
		if(roomId!=null){
			empService.acceptCaseById(roomId);
			str="�ӵ��ɹ���";
		}
		
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		req.setAttribute("foodList", roomGoodsList);
		req.setAttribute("RegSuccess", str);
		return "page/ajax/foodList";
	}
	@RequestMapping("waiterGoods")
	public String waiterGoods(String roomId){
		//�������еĶ���ʳ��ķ���
		List<Room> list = empService.findGoodsRoomByRoomId();
		//��󼯺ϵ���
		List<RoomGoodsList> roomGoodsList=new ArrayList<>(); 
		for(Room room : list){			
			List<Goods> fdList=empService.findGoodsBygoodsId(room.getRoomId());
			
			List<GoodsInfo> goodsInfoList=new ArrayList<GoodsInfo>();
			for(Goods goods:fdList){	
				
				List<RoomGoods> rd=empService.findCountById(room.getRoomId(), goods.getGoodsId());
				if(rd.size()!=0){
					for(int i=0;i<rd.size();i++){
						GoodsInfo goodsInfo=new GoodsInfo(goods.getGoodsId(),rd.get(i).getOrderCount(),goods.getGoodsName());
						goodsInfoList.add(goodsInfo);
					}					
				}
			}
			RoomGoodsList rfList=new RoomGoodsList(room.getRoomId(),goodsInfoList);
			roomGoodsList.add(rfList);
		}
		String str="";
		if(roomId!=null){
			empService.acceptCaseById(roomId);
			str="�ӵ��ɹ���";
		}
		
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		req.setAttribute("foodList", roomGoodsList);
		req.setAttribute("RegSuccess", str);
		return "page/waiterGoods";
	}
	/**
	 * ��ѯϵͳ��Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getInfo")
	public List<SystemInfo> getInfo(int flag){
		List<SystemInfo> infoList=empService.findfrontEmpInfo(flag);
		return infoList;
		
	}
	@RequestMapping("getWaiterInfo")
	public String getWaiterInfo(int flag){
		List<SystemInfo> infoList=empService.findfrontEmpInfo(flag);
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		req.setAttribute("infoList", infoList);
		return "page/waiterInfo";
		
	}
	/**
	 * �������ҳ��
	 * @return
	 */
	@RequestMapping("intoCommonPer")
	public String intoCommonPer(){
		return "page/commonPer";
	}
	/**
	 * �������Ա����
	 * @return
	 */
	@RequestMapping("intoWaiter")
	public String intoWaiter(){
		return "page/waiter";
	}
	/**
	 * ��ѯϵͳ��Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getInfoByTel")
	public List<SystemInfo> getInfoByTel(String tel){
		List<SystemInfo> infoList=null;
		if(tel!=null){
			infoList=empService.findfrontEmpInfoByempTel(tel);
		}		
		return infoList;
		
	}
}
