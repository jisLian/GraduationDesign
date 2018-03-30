package com.jis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jis.bean.Language;
import com.jis.dao.AddPriceDao;
import com.jis.dao.CustomerDao;
import com.jis.dao.EmployeeDao;
import com.jis.dao.GoodsDao;
import com.jis.dao.GoodsTypeDao;
import com.jis.dao.RoomTypeDao;
import com.jis.dao.SongDao;
import com.jis.dao.SongToTypeDao;
import com.jis.dao.StyleTypeDao;
import com.jis.dao.SystemInfoDao;
import com.jis.dao.VipDao;
import com.jis.form.AddGoodsInfo;
import com.jis.form.AddSongInfoForm;
import com.jis.form.UpdateSongForm;
import com.jis.pojo.AddPrice;
import com.jis.pojo.Customer;
import com.jis.pojo.Employee;
import com.jis.pojo.Goods;
import com.jis.pojo.GoodsType;
import com.jis.pojo.RoomType;
import com.jis.pojo.Song;
import com.jis.pojo.StyleType;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.Vip;

/**
 * ����Ա������
 * @author shu
 *
 */
@Service
public class ManagerService {
	@Autowired
	private SongDao songDao;
	@Autowired
	private StyleTypeDao styleTypeDao;
	@Autowired
	private SongToTypeDao songToTypeDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	@Autowired
	private RoomTypeDao roomTypeDao;
	@Autowired
	private AddPriceDao addpriceDao;
	@Autowired
	private VipDao vipDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private EmployeeDao employDao;
	@Autowired
	private SystemInfoDao systemInfoDao;
	/**
	 * �������еĸ���
	 * @return
	 */
	public List<Song> findSongByPageCode(int pageCode){
		return songDao.findSongByPageCode(pageCode);
	}
	/**
	 * ��ѯ���������з������
	 * @return
	 */
	public List<StyleType> findAllStyle(){
		return styleTypeDao.findAllStyle();
	}
	/**
	 * ��ѯ���и���������
	 * @return
	 */
	public List<Language> findAllLanguage(){
		return songDao.findAllLanguage();
	}
	/**
	 * �������ֲ��Ҹ���
	 * @param language
	 * @return
	 */
	public List<Song> findSongByLanguage(String language,int pageCode){
		return songDao.findSongByLanguage(language,pageCode);
	}
	/**
	 * ���Ҹ�����������
	 * @return
	 */
	public int findCount(){
		return songDao.findCount();
	}
	/**
	 * �������ֲ��Ҹ�����������
	 * @param language
	 * @return
	 */
	public int findCountByLanguage(String language){
		return songDao.findCountByLanguage(language);
	}
	/**
	 * �����������ݲ��Ҹ���
	 * @param input
	 * @return
	 */
	public List<Song> findSongBySearch(String input){
		return songDao.findSongBySearch(input);
	}
	/**
	 * ���ݸ�����������
	 * @param SongName
	 * @return
	 */
	public List<Song> findSongBySongName(String songName){
		return songDao.findSongBySongName(songName);
	}
	/**
	 * ���ݸ����ı��ɾ������
	 * @param songId
	 */
	public void deleteSongBySongId(int songId){
		songDao.deleteSongBySongId(songId);
		//���ݸ������ɾ������
		deleteSongToTypeBySongId(songId);
	}
	/**
	 * ���ݸ������ɾ���������
	 * @param songId
	 */
	public void deleteSongToTypeBySongId(int songId){
		songToTypeDao.deleteSongToTypeBySongId(songId);
	}
	/**
	 * ���ݸ�����Ų��Ҹ���
	 * @param songId
	 * @return
	 */
	public Song findSongBySongId(int songId){
		return songDao.findSongBySongId(songId);
	}
	/**
	 * ���ݸ�����Ų��ҷ��
	 * @param songId
	 * @return
	 */
	public List<StyleType> findTyleBySongId(int songId){
		return styleTypeDao.findTyleBySongId(songId);
	}
	/**
	 * ���ݸ�����Ÿ��¸�������
	 * @param form
	 */
	public void updateSongBySongId(UpdateSongForm form){
		songDao.updateSongBySongId(form);
	}
	/**
	 * ���ݸ�������޸ĸ������
	 * @param songId
	 * @param styleId
	 */
	public void addSongStyleBySongId(int songId,int styleId ){
		songToTypeDao.addSongStyleBySongId(songId, styleId);
	}
	/**
	 * ��Ӹ���
	 * @param songName
	 * @param songSinger
	 * @param language
	 * @param songTime
	 * @param pblishDate
	 * @param path
	 */
	public void addSong(AddSongInfoForm addSongForm){
		songDao.addSong(addSongForm);	
	}
	/**
	 * ���ݸ�����·�����Ҹ���
	 * @param songPath
	 * @return
	 */
	public Song findSongBySongPath(String songPath){
		return songDao.findSongBySongPath(songPath);
	}
	/**
	 * ��ȡȡ������Ʒ
	 * @return
	 */
	public List<Goods> findAllGoods(int pageCode){
		return goodsDao.findAllGoods(pageCode);
	}
	/**
	 * �������Ͳ��Ҷ�Ӧ����Ʒ
	 * @param typeId
	 * @return
	 */
	public List<Goods> findGoodsByTypeId(int typeId,int pageCode){
		return goodsDao.findGoodsByTypeId(typeId, pageCode);
	}
	/**
	 * ��ȡ������Ʒ����
	 * @return
	 */
	public int findAllGoodsCount(){
		return goodsDao.findAllGoodsCount();
	}
	/**
	 * �������Ͳ��Ҷ�Ӧ����Ʒ����
	 * @param typeId
	 * @return
	 */
	public int findGoodsCountByTypeId(int typeId){
		return goodsDao.findGoodsCountByTypeId(typeId);
	}
	/**
	 * ���ݷ���ż��㷿��ʳ�������ܼ�
	 * @param roomId
	 * @return
	 */
	public float countGoodsFee(String roomId){
		return goodsDao.countGoodsFee(roomId);
	}
	/**
	 * ��ѯ����ʳƷ�ķ���
	 * @return
	 */
	public List<GoodsType> findGoodsTypes(){
		return goodsTypeDao.findGoodsTypes();
	}
	/**
	 * ������Ʒ
	 * @param searchContent
	 * @return
	 */
	public List<Goods> searchGoods(String searchContent){
		return goodsDao.searchGoods(searchContent);
	}
	/**
	 * ��ȡ���з�������
	 * @return
	 */
	public List<RoomType> findAllRoomType(){
		return roomTypeDao.findAllRoomType();
	}
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
	 * ��ȡ���мӼۼ۸�
	 * @return
	 */
	public List<AddPrice> getAllDiscount(){
		return addpriceDao.getAllDiscount();
	}
	/**
	 * ��ʱ��μ۸��޸�
	 */
	public void updateDiscountFeeByTimeId(double fee,int roomTypeId,int timeId){
		addpriceDao.updateDiscountFeeByTimeId(fee, roomTypeId, timeId);
	}
	/**
	 * �����Ʒ
	 * @param addGoodsInfo
	 */
	public void addGoods(AddGoodsInfo addGoodsInfo){
		goodsDao.addGoods(addGoodsInfo);
	}
	/**
	 * ������Ʒ���ɾ����Ʒ
	 * @param goodsId
	 */
	public void deleteGoods(int goodsId){
		goodsDao.deleteGoods(goodsId);
	}
	/**
	 * �����Ʒ����
	 * @param GoodstypeName
	 */
	public void addGoodsType(String GoodstypeName){
		goodsTypeDao.addGoodsType(GoodstypeName);
	}
	/**
	 * ɾ����Ʒ����
	 * @param goodsTypeId
	 */
	public void deleteGoodsType(int goodsTypeId){
		goodsDao.deleteGoodsByTypeId(goodsTypeId);
		goodsTypeDao.deleteGoodsType(goodsTypeId);
	}
	/**
	 * �޸���Ʒ����Ϣ
	 */
	public void updateGoodsInfo(int goodsId,String goodsName,float goodsPrice,int goodsCount,int flag){
		goodsDao.updateGoodsInfo(goodsId, goodsName,goodsPrice, goodsCount,flag);
	}
	/**
	 * ��������VIp
	 * @return
	 */
	public List<Vip> findAllVip(){
		return vipDao.findAllVip();
	}
	/**
	 * ����vipɾ��Vip
	 * @param vipId
	 */
	public void deleteVipById(int vipId){
		vipDao.deleteVipById(vipId);
	}
	/**
	 * ����������ͨ�û�
	 * @return
	 */
	public List<Customer> findAllCustomer(){
		return customerDao.findAllCustomer();
	}
	/**
	 * ���ݹ˿͵ı��ɾ���˿�
	 * @param customerId
	 */
	public void deleteCustomerById(int customerId){
		customerDao.deleteCustomerById(customerId);
	}
	/**
	 * ��������Ա��
	 * @return
	 */
	public List<Employee> findAllEmp(){
		return employDao.findAllEmp();
	}
	/**
	 * ����ԭ���ɾ��Ա��
	 * @param empId
	 */
	public void deleteEmpByempId(int empId){
		employDao.deleteEmpByempId(empId);
	}
	/**
	 * ����Ա����������Ա��
	 * @param empName
	 * @return
	 */
	public List<Employee> searchEmp(String empName){
		return employDao.searchEmp(empName);
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
	 * ����Ա���ĵ绰����Ա��
	 * @param Tel
	 * @return
	 */
	public Employee findEmpByEmpTel(String Tel){
		return employDao.findEmpByEmpTel(Tel);
	}
	/**
	 * ���ϵͳ֪ͨ��Ϣ
	 * @param titleContent
	 * @param relative
	 * @param content
	 */
	public void addSystemInfo(SystemInfo systemInfo){
		systemInfoDao.addSystemInfo(systemInfo);
	}
}
