package com.jis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jis.dao.GoodsDao;
import com.jis.dao.GoodsTypeDao;
import com.jis.dao.RoomDao;
import com.jis.dao.RoomGoodsDao;
import com.jis.dao.SystemInfoDao;
import com.jis.dao.VipDao;
import com.jis.pojo.Goods;
import com.jis.pojo.GoodsType;
import com.jis.pojo.Room;
import com.jis.pojo.RoomGoods;
import com.jis.pojo.SystemInfo;
import com.jis.pojo.Vip;

/**
 * 顾客服务类
 * @author shu
 *
 */
@Service
public class CustomerService {
	@Autowired 
	private VipDao vipDao;
	@Autowired 
	private GoodsDao goodsDao;
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private RoomGoodsDao roomGoodsDao;
	@Autowired
	private SystemInfoDao systemInfoDao;
	/**
	 * 根据VIP的编号查找VIP用户
	 * @param vipId
	 * @return
	 */
	public Vip findVipByVipId(int vipId){
		return vipDao.findVipByVipId(vipId);
	}
	/**
	 * 根据VIP的名称查找VIP用户
	 * @param vipName
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel){
		return vipDao.findVipByVipTel(vipTel);
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
	 * 根据房间编号查找对应的食物
	 * @param roomId
	 * @return
	 */
	public List<Goods> findGoodsBygoodsId(String roomId){
		return goodsDao.findGoodsBygoodsId(roomId);
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
	 * 根据商品类型的编号查找商品类型
	 * @return
	 */
	public GoodsType findGoodsTypeByGoodsTypeId(){
		return goodsTypeDao.findGoodsTypeByGoodsTypeId();
	}
	/**
	 * 根据vip编号修改vip密码
	 * @param vipId
	 */
	public void updtatePwd(int vipId,String pwd){
		vipDao.updtatePwd(vipId,pwd);
	}
	/**
	 * 根据房间编号查找房间
	 * @param roomId
	 * @return
	 */
	public Room findRoomByroomId(String roomId){
		return roomDao.findRoomByroomId(roomId);
	}
	/**
	 * 添加食品到房间购物清单
	 * @param roomFood
	 * @return
	 */
	public void addFoodToRoom(RoomGoods roomGoods){
		roomGoodsDao.addFoodToRoom(roomGoods);
		goodsDao.updateGoodsCount(roomGoods.getGoodsId(), roomGoods.getOrderCount());
	}
	/**
	 * 根据电话和身份标识查找系统消息
	 * @param tel
	 * @param flag
	 * @return
	 */
	public List<SystemInfo> findinfo(String tel,int flag){
		return systemInfoDao.findinfo(tel, flag);
	}
}
