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
 * Ա��������
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
	 * ����Ա����Ų���Ա��
	 * @param empId
	 * @return
	 */
	public Employee findEmpByempId(int empId){
		return empDao.findEmpByempId(empId);
	}
	/**
	 * ��ȡ���з�������
	 * @return
	 */
	public List<RoomType> findAllRoomType(){
		return roomTypeDao.findAllRoomType();
	};
	/**
	 * �޸İ�������
	 * @param roomTypeId
	 */
	public void updateRoomTypeById(String typeName,int fee,int roomTypeId){
		roomTypeDao.updateRoomTypeById(typeName, fee, roomTypeId);
	}
	/**
	 * ������������
	 */
	public void addRoomType(String roomTypeName,int fee){
		roomTypeDao.addRoomType(roomTypeName, fee);
	}
	
	/**
	 * ���ݷ����Ų��Ҹ÷���
	 * @param roomTypeId
	 * @return
	 */
	public RoomType findRoomTypeById(int roomTypeId){
		return roomTypeDao.findRoomTypeById(roomTypeId);
	}
	/**
	 * ͨ��ʱ�䷶Χ�ҷ���ʹ�ü�¼
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByTime(Date start,Date end){
		return roomRecordDao.getRoomRecordByTime(start, end);
	}
	/**
	 * ͨ�������id��ʱ�䷶Χ��ʹ�ü�¼
	 * @param start
	 * @param end
	 * @param roomId
	 * @return
	 */
	public List<RoomRecord> getRoomRecordByRoomAndTime(Date start,Date end,String roomId){
		return roomRecordDao.getRoomRecordByRoomAndTime(start, end, roomId);
	}
	
	/**
	 * ����µķ���ʹ�ü�¼
	 * @param r
	 */
	public void AddRecord(RoomRecord r){
		roomRecordDao.AddRecord(r);
		
	}
	
	/**
	 * ���ݷ���id��������ʹ�õķ���ʹ�ü�¼��Ϣ
	 * @param roomId
	 * @return
	 */
	public RoomRecord findCustomerIdByRoomId(String roomId){
		return roomRecordDao.findCustomerIdByRoomId(roomId);
	}
	/**
	 *���Ѳ������½���ʱ�������
	 * @param record
	 */
	public void updateRoomRecord(RoomRecord record){
		roomRecordDao.updateRoomRecord(record);
	}
	/**
	 * �˷���������ʵ�ʽ���ʱ��ͷ���
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
	 * ����µ��û�
	 * @param c
	 */
	public void AddCustomer(Customer c){
		customerDao.AddCustomer(c);
	}	
	/**
	 * �����û������ҿͻ���Ϣ
	 * @param name
	 * @return
	 */
	public Customer findCustomerByTel(String tel){
		return customerDao.findCustomerByTel(tel);
	}	
	/**
	 * �����û�id���ҿͻ�
	 * @param cid
	 * @return
	 */
	public Customer findCustomerById(int cid){
		return customerDao.findCustomerById(cid);
	}
	
	/**
	 * �����û��绰��Ϣ
	 * @param tel
	 * @param customerId
	 */
	public void updateTel(String tel,int customerId){
		customerDao.updateTel(tel, customerId);
	}
	/**
	 * ���¹˿͵�����
	 * @param customerName
	 * @param customerId
	 */
	public void updateName(String customerName,int customerId){
		customerDao.updateName(customerName, customerId);
		vipDao.updateVipName(customerName, customerId);
	}
	/**
	 * ��ȡ���еķ���
	 * @return
	 * @author run
	 */
	public List<Room> getAllRoom(){
		return roomDao.getAllRoom();
	}
	/**
	 * �޸İ�������
	 * @param roomTypeId���ͱ��
	 * @param roomId������
	 */
	public void updateRoomTypeByRoomId(int roomTypeId,String roomId){
		roomDao.updateRoomTypeByRoomId(roomTypeId, roomId);
	}
	
	/**
	 * ���ݷ������ͱ�Ų��ҿյķ���
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findEmptyRoomById(int roomTypeId){
		return roomDao.findEmptyRoomById(roomTypeId);
	}
	/**
	 * ���ݷ������ͱ�Ų����Ѿ�ʹ�õķ���
	 * @param roomTypeId
	 * @return
	 */
	public List<Room> findHasUseRoomById(int roomTypeId){
		return roomDao.findHasUseRoomById(roomTypeId);
	}
	/**
	 * ���ݷ���id���·����ʹ�ñ�ʶ
	 * @param roomId
	 */
	public void updateRoomUseFlag(String roomId){
		roomDao.updateRoomUseFlag(roomId);
	}
	/**
	 * ���ݷ���id�˶����䣬����ʹ�ñ�ʶ
	 * @param roomId
	 */
	public void updateRoomExitFlag(String roomId){
		roomDao.updateRoomExitFlag(roomId);
	}
	
	/**
	 * ���ݷ����Ų��ҷ���
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
	 * �޸ļӼ�ʱ���
	 */
	public void updateTimeRand(Date start,Date end,int timeId){
		timeFeeDao.updateTimeRand(start, end, timeId);
	}
	/**
	 * ��ȡ���мӼ�ʱ���
	 * @return
	 */
	public List<TimeFee> getAllTimeFee(){
		return timeFeeDao.getAllTimeFee();
	}
	/**
	 * ����ʱ��η���
	 * @return
	 */
	public TimeFee findFee(){
		return timeFeeDao.findFee();
	}
	
	/**
	 * ���ݷ���id��ʱ���id���Ҿ����ۿ�
	 * @param roomTypeId
	 * @param timeId
	 * @return
	 */
	public AddPrice findDisById(int roomTypeId,int timeId){
		return addPriceDao.findDisById(roomTypeId, timeId);
	}
	/**
	 * ��ȡ���мӼۼ۸�
	 * @return
	 */
	public List<AddPrice> getAllDiscount(){
		return addPriceDao.getAllDiscount();
	}
	/**
	 * ����µĻ�Ա
	 * @param v
	 */
	public void AddVip(Vip v){
		vipDao.AddVip(v);
	}
	/**
	 * ���»�Ա�ĵȼ����ۿ۱�׼
	 * @param vipId
	 */
	public void AddVipLevel(int vipId){
		vipDao.AddVipLevel(vipId);
	}
	/**
	 * ����VIP�ĵ绰����VIP�û�
	 * @param vipName
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel){
		return vipDao.findVipByVipTel(vipTel);
	}
	/**
	 * �������ж���ʳ��İ���
	 * @return
	 */
	public List<Room> findGoodsRoomByRoomId(){
		return roomDao.findGoodsRoomByRoomId();
	}
	/**
	 * ���ݷ����Ų��Ҷ�Ӧ��ʳ��
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
	 * �ӵ�
	 * @param roomId
	 */
	public void acceptCaseById(String roomId){
		roomGoodsDao.acceptCaseById(roomId);
	}
	/**
	 * ������ݲ���ǰ̨��Ա��ص���Ϣ��������Ϣ��
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfo(int Flag){
		return systemInfoDao.findfrontEmpInfo(Flag);
	}
	/**
	 * ����Ա���ĵ绰���������Ϣ(˽��)
	 * @param empTel
	 * @return
	 */
	public List<SystemInfo> findfrontEmpInfoByempTel(String empTel){
		return systemInfoDao.findfrontEmpInfoByempTel(empTel);
	}
}
