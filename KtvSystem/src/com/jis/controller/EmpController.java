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
 * 普通员工控制器
 * @author shu
 *
 */
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	/**
	 * 跳转进总台（前台人员）页面
	 * @return
	 */
	@RequestMapping("frontEmp")
	public String jumpFrontEmp(){
		return "page/frontEmp";
	}
	/**
	 * 查找空包厢
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("EmptyRoom")
	public List<Room> EmptyRoom(int roomTypeId){
		return empService.findEmptyRoomById(roomTypeId);
	}
	/**
	 * 获取包厢价格
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("price")
	public String price(int roomTypeId){
		//根据房间编号查找房间类型
		RoomType roomType=empService.findRoomTypeById(roomTypeId);
		float disCount=1;		
		if(roomType!=null){
			//获取每个时间的价格
			int perFee=roomType.getPerFee();
			return perFee+"";
			//获取时间段分类
			/*TimeFee timeFee= empService.findFee();
			if(timeFee!=null){
				//获取房间类型的折扣价
				AddPrice discount=empService.findDisById(roomTypeId, timeFee.getTimeId());
				disCount=discount.getDiscountPrice();
			}
		
			return new Float(disCount*perFee).toString();*/
		}
		return null;
	}
	/**
	 * 查询已使用的包厢号
	 * @param roomTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("HasUseRoom")
	public List<Room> HasUseRoom(int roomTypeId){
		return empService.findHasUseRoomById(roomTypeId);
	}
	/**
	 * 根据用户的电话查找用户
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
	 * 查询顾客的电话号码
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
	 * 退房初始化
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
		//创建JSON对象
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
	 * 续订包厢操作
	 * @param renewRoomForm
	 * @return
	 */
	@RequestMapping("renewRoom")
	public String renewRoom(RenewRoomForm renewRoomForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取房间类型
		List<RoomType> list=empService.findAllRoomType();
		//将所有房间类型写入请求
		req.setAttribute("roomTypeList", list);
		//获取令牌（防刷新）
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=renewRoomForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//续费操作
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
			str="续费成功！";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	/**
	 * 注册会员操作
	 * @param registVip
	 * @return
	 */
	@RequestMapping("regVip")
	public String regVip(RegistVipForm registVip){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取房间类型
		List<RoomType> list=empService.findAllRoomType();
		//将所有房间类型写入请求
		req.setAttribute("roomTypeList", list);
		//获取令牌（防刷新）
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=registVip.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//注册会员
		if(registVip!=null&&serverToken!=null&&serverToken.toString().equals(token)){			
			Customer c=empService.findCustomerByTel(registVip.getRegTel());
			//若此会员没有客户记录，先添加
			if(c==null){
				Customer customer=new Customer(registVip.getRegName(),registVip.getRegTel());
				empService.AddCustomer(customer);
			}
			//查找客户得到id
			Customer Newcustomer=empService.findCustomerByTel(registVip.getRegTel());
			Vip v=new Vip(Newcustomer.getCustomerId(),Newcustomer.getCustomerName(),Newcustomer.getCustomerTel(),registVip.getBirthday(),registVip.getVipSex());
			//添加会员
			empService.AddVip(v);	
			str="注册成功";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	
	/**
	 * 退房操作
	 * @param exitRoomForm
	 * @return
	 */
	@RequestMapping("showExitRoom")
	public String exitRoom(ExitRoomForm exitRoomForm){
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取房间类型
		List<RoomType> list=empService.findAllRoomType();
		//将所有房间类型写入请求
		req.setAttribute("roomTypeList", list);
		//获取令牌（防刷新）
		//String token=(String) req.getAttribute(Token.TOKEN);
		String token=exitRoomForm.getToken();
		Object serverToken=req.getSession().getAttribute(Token.TOKEN);
		System.out.println("token"+token+"serverToken"+serverToken);
		String str="";
		//退房操作
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
			str="退房成功！";
			req.setAttribute("RegSuccess",str);
		}
		return "page/frontEmp";
	}
	@RequestMapping("foodList")
	public String foodLst(String roomId){
		//查找所有的订购食物的房间
		List<Room> list = empService.findGoodsRoomByRoomId();
		//最后集合的类
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
			str="接单成功！";
		}
		
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		req.setAttribute("foodList", roomGoodsList);
		req.setAttribute("RegSuccess", str);
		return "page/ajax/foodList";
	}
	@RequestMapping("waiterGoods")
	public String waiterGoods(String roomId){
		//查找所有的订购食物的房间
		List<Room> list = empService.findGoodsRoomByRoomId();
		//最后集合的类
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
			str="接单成功！";
		}
		
		HttpServletRequest req=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		req.setAttribute("foodList", roomGoodsList);
		req.setAttribute("RegSuccess", str);
		return "page/waiterGoods";
	}
	/**
	 * 查询系统消息
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
	 * 进入个人页面
	 * @return
	 */
	@RequestMapping("intoCommonPer")
	public String intoCommonPer(){
		return "page/commonPer";
	}
	/**
	 * 进入服务员界面
	 * @return
	 */
	@RequestMapping("intoWaiter")
	public String intoWaiter(){
		return "page/waiter";
	}
	/**
	 * 查询系统消息
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
