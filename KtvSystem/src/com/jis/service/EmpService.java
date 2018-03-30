package com.jis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jis.dao.AddPriceDao;
import com.jis.dao.CustomerDao;
import com.jis.dao.EmployeeDao;
import com.jis.dao.GoodsDao;
import com.jis.dao.RoomDao;
import com.jis.dao.RoomGoodsDao;
import com.jis.dao.RoomRecordDao;
import com.jis.dao.RoomTypeDao;
import com.jis.dao.SystemInfoDao;
import com.jis.dao.TimeFeeDao;
import com.jis.dao.VipDao;
import com.jis.pojo.AddPrice;
import com.jis.pojo.Customer;
import com.jis.pojo.Employee;
import com.jis.pojo.Goods;
import com.jis.pojo.Room;
import com.jis.pojo.RoomGoods;
import com.jis.pojo.RoomRecord;
import com.jis.pojo.RoomType;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.TimeFee;
import com.jis.pojo.Vip;

/**
 * 员工服务类
 * @author shu
 *
 */
@Service
public class EmpService {
	@Autowired
	private EmployeeDao empDao;
	@Autowired 
	private RoomTypeDao roomTypeDao;
	@Autowired
	private RoomRecordDao roomRecordDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TimeFeeDao timeFeeDao;
	@Autowired
	private AddPriceDao addPriceDao;
	@Autowired
	private VipDao vipDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private RoomGoodsDao roomGoodsDao;
	@Autowired
	private SystemInfoDao systemInfoDao;
	
	/**
	 * 根据员工编号查找员工
	 * @param empId
	 * @return
	 */
	public Employee findEmpByempId(int empId){
		return empDao.findEmpByempId(empId);
	}
	/**
	 * 获取所有房间类型
	 * @return
	 */
	public List<RoomType> findAllRoomType(){
		return roomTypeDao.findAllRoomType();
	};
	/**
	 * 修改包厢类型
	 * @param roomTypeId
	 */
	public void updateRoomTypeById(String typeName,int fee,int roomTypeId){
		roomTypeDao.updateRoomTypeById(typeName, fee, roomTypeId);
	}
	/**
	 * 新增包厢类型
	 */
	public void addRoomType(String roomTypeName,int fee){
		roomTypeDao.addRoomType(roomTypeName, fee);
	}
	
	/**
	 * 根据房间编号查找该房间
	 * @param roomTypeId
	 * @return
	 */
	public RoomType findRoomTypeById(int roomTypeId){
		return roomTypeDao.findRoomTypeById(roomTypeId);
	}
	/**
	 * 通过时间范围找房间使用记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByTime(Date start,Date end){
		return roomRecordDao.getRoomRecordByTime(start, end);
	}
	/**
	 * 通过房间的id和时间范围找使用记录
	 * @param start
	 * @param end
	 * @param roomId
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByRoomAndTime(Date start,Date end,String roomId){
		return roomRecordDao.getRoomRecordByRoomAndTime(start, end, roomId);
	}
	
	/**
	 * 添加新的房间使用记录
	 * @param r
	 */
	public void AddRecord(RoomRecord r){
		roomRecordDao.AddRecord(r);
		
	}
	
	/**
	 * 根据房间id查找正在使用的房间使用记录信息
	 * @param roomId
	 * @return
	 */
	public RoomRecord findCustomerIdByRoomId(String roomId){
		return roomRecordDao.findCustomerIdByRoomId(roomId);
	}
	/**
	 *续费操作更新结束时间和消费
	 * @param record
	 */
	public void updateRoomRecord(RoomRecord record){
		roomRecordDao.updateRoomRecord(record);
	}
	/**
	 * 退房操作更新实际结束时间和费用
	 * @param record
	 */
	public void exitRoomRecord(RoomRecord record){
		roomRecordDao.exitRoomRecord(record);
	}
	public void insertExitRecord(String roomId){
		roomRecordDao.insertExitRecord(roomId);
	}
	
	public RoomRecord findUserRoomRecord(String id){
		return roomRecordDao.findUserRoomRecord(id);
	}
	/**
	 * 添加新的用户
	 * @param c
	 */
	public void AddCustomer(Customer c){
		customerDao.AddCustomer(c);
	}	
	/**
	 * 根据用户名查找客户信息
	 * @param name
	 * @return
	 */
	public Customer findCustomerByTel(String tel){
		return customerDao.findCustomerByTel(tel);
	}	
	/**
	 * 根据用户id查找客户
	 * @param cid
	 * @return
	 */
	public Customer findCustomerById(int cid){
		return customerDao.findCustomerById(cid);
	}
	
	/**
	 * 更新用户电话信息
	 * @param tel
	 * @param customerId
	 */
	public void updateTel(String tel,int customerId){
		customerDao.updateTel(tel, customerId);
	}
	/**
	 * 更新顾客的姓名
	 * @param customerName
	 * @param customerId
	 */
	public void updateName(String customerName,int customerId){
		customerDao.updateName(customerName, customerId);
		vipDao.updateVipName(customerName, customerId);
	}
	/**
	 * 获取所有的房间
	 * @return
	 * @author run
	 */
	public List<Room> getAllRoom(){
		return roomDao.getAllRoom();
	}
	/**
	 * 修改包厢类型
	 * @param roomTypeId类型编号
	 * @param roomId房间编号
	 */
	public void updateRoomTypeByRoomId(int roomTypeId,String roomId){
		roomDao.updateRoomTypeByRoomId(roomTypeId, roomId);
	}
	
	/**
	 * 根据房间类型编号查找空的房间
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findEmptyRoomById(int roomTypeId){
		return roomDao.findEmptyRoomById(roomTypeId);
	}
	/**
	 * 根据房间类型编号查找已经使用的房间
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findHasUseRoomById(int roomTypeId){
		return roomDao.findHasUseRoomById(roomTypeId);
	}
	/**
	 * 根据房间id更新房间的使用标识
	 * @param roomId
	 */
	public void updateRoomUseFlag(String roomId){
		roomDao.updateRoomUseFlag(roomId);
	}
	/**
	 * 根据房间id退订房间，销毁使用标识
	 * @param roomId
	 */
	public void updateRoomExitFlag(String roomId){
		roomDao.updateRoomExitFlag(roomId);
	}
	
	/**
	 * 根据房间编号查找房间
	 * @param roomId
	 * @return
	 */
	public Room findRoomByroomId(String roomId){
		return roomDao.findRoomByroomId(roomId);
	}
	public void setRoomFree(String roomId){
		roomDao.setRoomFree(roomId);
	}
	/**
	 * 修改加价时间段
	 */
	public void updateTimeRand(Date start,Date end,int timeId){
		timeFeeDao.updateTimeRand(start, end, timeId);
	}
	/**
	 * 获取所有加价时间段
	 * @return
	 */
	public List<TimeFee> getAllTimeFee(){
		return timeFeeDao.getAllTimeFee();
	}
	/**
	 * 查找时间段分类
	 * @return
	 */
	public TimeFee findFee(){
		return timeFeeDao.findFee();
	}
	
	/**
	 * 根据房间id和时间段id查找具体折扣
	 * @param roomTypeId
	 * @param timeId
	 * @return
	 */
	public AddPrice findDisById(int roomTypeId,int timeId){
		return addPriceDao.findDisById(roomTypeId, timeId);
	}
	/**
	 * 获取所有加价价格
	 * @return
	 */
	public List<AddPrice> getAllDiscount(){
		return addPriceDao.getAllDiscount();
	}
	/**
	 * 添加新的会员
	 * @param v
	 */
	public void AddVip(Vip v){
		vipDao.AddVip(v);
	}
	/**
	 * 更新会员的等级和折扣标准
	 * @param vipId
	 */
	public void AddVipLevel(int vipId){
		vipDao.AddVipLevel(vipId);
	}
	/**
	 * 根据VIP的电话查找VIP用户
	 * @param vipName
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel){
		return vipDao.findVipByVipTel(vipTel);
	}
	/**
	 * 查找所有订购食物的包厢
	 * @return
	 */
	public List<Room> findGoodsRoomByRoomId(){
		return roomDao.findGoodsRoomByRoomId();
	}
	/**
	 * 根据房间编号查找对应的食物
	 * @param roomId
	 * @return
	 */
	public List<Goods> findGoodsBygoodsId(String roomId){
		return goodsDao.findGoodsBygoodsId(roomId);
	}
	public List<RoomGoods> findCountById(String roomId,int foodId){
		return roomGoodsDao.findCountById(roomId, foodId);
	}
	/**
	 * 接单
	 * @param roomId
	 */
	public void acceptCaseById(String roomId){
		roomGoodsDao.acceptCaseById(roomId);
	}
	/**
	 * 根据身份查找前台人员相关的消息（公用信息）
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfo(int Flag){
		return systemInfoDao.findfrontEmpInfo(Flag);
	}
	/**
	 * 根据员工的电话查找相关消息(私信)
	 * @param empTel
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfoByempTel(String empTel){
		return systemInfoDao.findfrontEmpInfoByempTel(empTel);
	}
}
