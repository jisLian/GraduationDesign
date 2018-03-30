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
 * 管理员服务类
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
	 * 查找所有的歌曲
	 * @return
	 */
	public List<Song> findSongByPageCode(int pageCode){
		return songDao.findSongByPageCode(pageCode);
	}
	/**
	 * 查询歌曲的所有风格类型
	 * @return
	 */
	public List<StyleType> findAllStyle(){
		return styleTypeDao.findAllStyle();
	}
	/**
	 * 查询所有歌曲的语种
	 * @return
	 */
	public List<Language> findAllLanguage(){
		return songDao.findAllLanguage();
	}
	/**
	 * 根据语种查找歌曲
	 * @param language
	 * @return
	 */
	public List<Song> findSongByLanguage(String language,int pageCode){
		return songDao.findSongByLanguage(language,pageCode);
	}
	/**
	 * 查找歌曲的总数量
	 * @return
	 */
	public int findCount(){
		return songDao.findCount();
	}
	/**
	 * 根据语种查找歌曲的总数量
	 * @param language
	 * @return
	 */
	public int findCountByLanguage(String language){
		return songDao.findCountByLanguage(language);
	}
	/**
	 * 根据搜索内容查找歌曲
	 * @param input
	 * @return
	 */
	public List<Song> findSongBySearch(String input){
		return songDao.findSongBySearch(input);
	}
	/**
	 * 根据歌名搜索歌曲
	 * @param SongName
	 * @return
	 */
	public List<Song> findSongBySongName(String songName){
		return songDao.findSongBySongName(songName);
	}
	/**
	 * 根据歌曲的编号删除歌曲
	 * @param songId
	 */
	public void deleteSongBySongId(int songId){
		songDao.deleteSongBySongId(songId);
		//根据歌曲编号删除歌曲
		deleteSongToTypeBySongId(songId);
	}
	/**
	 * 根据歌曲编号删除歌曲风格
	 * @param songId
	 */
	public void deleteSongToTypeBySongId(int songId){
		songToTypeDao.deleteSongToTypeBySongId(songId);
	}
	/**
	 * 根据歌曲编号查找歌曲
	 * @param songId
	 * @return
	 */
	public Song findSongBySongId(int songId){
		return songDao.findSongBySongId(songId);
	}
	/**
	 * 根据歌曲编号查找风格
	 * @param songId
	 * @return
	 */
	public List<StyleType> findTyleBySongId(int songId){
		return styleTypeDao.findTyleBySongId(songId);
	}
	/**
	 * 根据歌曲编号跟新歌曲内容
	 * @param form
	 */
	public void updateSongBySongId(UpdateSongForm form){
		songDao.updateSongBySongId(form);
	}
	/**
	 * 根据歌曲编号修改歌曲风格
	 * @param songId
	 * @param styleId
	 */
	public void addSongStyleBySongId(int songId,int styleId ){
		songToTypeDao.addSongStyleBySongId(songId, styleId);
	}
	/**
	 * 添加歌曲
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
	 * 根据歌曲的路径查找歌曲
	 * @param songPath
	 * @return
	 */
	public Song findSongBySongPath(String songPath){
		return songDao.findSongBySongPath(songPath);
	}
	/**
	 * 获取取所有商品
	 * @return
	 */
	public List<Goods> findAllGoods(int pageCode){
		return goodsDao.findAllGoods(pageCode);
	}
	/**
	 * 根据类型查找对应的商品
	 * @param typeId
	 * @return
	 */
	public List<Goods> findGoodsByTypeId(int typeId,int pageCode){
		return goodsDao.findGoodsByTypeId(typeId, pageCode);
	}
	/**
	 * 获取所有商品数量
	 * @return
	 */
	public int findAllGoodsCount(){
		return goodsDao.findAllGoodsCount();
	}
	/**
	 * 根据类型查找对应的商品数量
	 * @param typeId
	 * @return
	 */
	public int findGoodsCountByTypeId(int typeId){
		return goodsDao.findGoodsCountByTypeId(typeId);
	}
	/**
	 * 根据房间号计算房间食物消费总价
	 * @param roomId
	 * @return
	 */
	public float countGoodsFee(String roomId){
		return goodsDao.countGoodsFee(roomId);
	}
	/**
	 * 查询所有食品的分类
	 * @return
	 */
	public List<GoodsType> findGoodsTypes(){
		return goodsTypeDao.findGoodsTypes();
	}
	/**
	 * 搜索商品
	 * @param searchContent
	 * @return
	 */
	public List<Goods> searchGoods(String searchContent){
		return goodsDao.searchGoods(searchContent);
	}
	/**
	 * 获取所有房间类型
	 * @return
	 */
	public List<RoomType> findAllRoomType(){
		return roomTypeDao.findAllRoomType();
	}
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
	 * 获取所有加价价格
	 * @return
	 */
	public List<AddPrice> getAllDiscount(){
		return addpriceDao.getAllDiscount();
	}
	/**
	 * 对时间段价格修改
	 */
	public void updateDiscountFeeByTimeId(double fee,int roomTypeId,int timeId){
		addpriceDao.updateDiscountFeeByTimeId(fee, roomTypeId, timeId);
	}
	/**
	 * 添加商品
	 * @param addGoodsInfo
	 */
	public void addGoods(AddGoodsInfo addGoodsInfo){
		goodsDao.addGoods(addGoodsInfo);
	}
	/**
	 * 根据商品编号删除商品
	 * @param goodsId
	 */
	public void deleteGoods(int goodsId){
		goodsDao.deleteGoods(goodsId);
	}
	/**
	 * 添加商品分类
	 * @param GoodstypeName
	 */
	public void addGoodsType(String GoodstypeName){
		goodsTypeDao.addGoodsType(GoodstypeName);
	}
	/**
	 * 删除商品分类
	 * @param goodsTypeId
	 */
	public void deleteGoodsType(int goodsTypeId){
		goodsDao.deleteGoodsByTypeId(goodsTypeId);
		goodsTypeDao.deleteGoodsType(goodsTypeId);
	}
	/**
	 * 修改商品的信息
	 */
	public void updateGoodsInfo(int goodsId,String goodsName,float goodsPrice,int goodsCount,int flag){
		goodsDao.updateGoodsInfo(goodsId, goodsName,goodsPrice, goodsCount,flag);
	}
	/**
	 * 查找所有VIp
	 * @return
	 */
	public List<Vip> findAllVip(){
		return vipDao.findAllVip();
	}
	/**
	 * 根据vip删除Vip
	 * @param vipId
	 */
	public void deleteVipById(int vipId){
		vipDao.deleteVipById(vipId);
	}
	/**
	 * 查找所有普通用户
	 * @return
	 */
	public List<Customer> findAllCustomer(){
		return customerDao.findAllCustomer();
	}
	/**
	 * 根据顾客的编号删除顾客
	 * @param customerId
	 */
	public void deleteCustomerById(int customerId){
		customerDao.deleteCustomerById(customerId);
	}
	/**
	 * 查找所有员工
	 * @return
	 */
	public List<Employee> findAllEmp(){
		return employDao.findAllEmp();
	}
	/**
	 * 根据原编号删除员工
	 * @param empId
	 */
	public void deleteEmpByempId(int empId){
		employDao.deleteEmpByempId(empId);
	}
	/**
	 * 根据员工姓名查找员工
	 * @param empName
	 * @return
	 */
	public List<Employee> searchEmp(String empName){
		return employDao.searchEmp(empName);
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
	 * 根据员工的电话查找员工
	 * @param Tel
	 * @return
	 */
	public Employee findEmpByEmpTel(String Tel){
		return employDao.findEmpByEmpTel(Tel);
	}
	/**
	 * 添加系统通知消息
	 * @param titleContent
	 * @param relative
	 * @param content
	 */
	public void addSystemInfo(SystemInfo systemInfo){
		systemInfoDao.addSystemInfo(systemInfo);
	}
}
