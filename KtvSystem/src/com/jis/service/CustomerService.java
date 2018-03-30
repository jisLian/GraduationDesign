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
 * �˿ͷ�����
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
	 * ����VIP�ı�Ų���VIP�û�
	 * @param vipId
	 * @return
	 */
	public Vip findVipByVipId(int vipId){
		return vipDao.findVipByVipId(vipId);
	}
	/**
	 * ����VIP�����Ʋ���VIP�û�
	 * @param vipName
	 * @return
	 */
	public Vip findVipByVipTel(String vipTel){
		return vipDao.findVipByVipTel(vipTel);
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
	 * ���ݷ����Ų��Ҷ�Ӧ��ʳ��
	 * @param roomId
	 * @return
	 */
	public List<Goods> findGoodsBygoodsId(String roomId){
		return goodsDao.findGoodsBygoodsId(roomId);
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
	 * ������Ʒ���͵ı�Ų�����Ʒ����
	 * @return
	 */
	public GoodsType findGoodsTypeByGoodsTypeId(){
		return goodsTypeDao.findGoodsTypeByGoodsTypeId();
	}
	/**
	 * ����vip����޸�vip����
	 * @param vipId
	 */
	public void updtatePwd(int vipId,String pwd){
		vipDao.updtatePwd(vipId,pwd);
	}
	/**
	 * ���ݷ����Ų��ҷ���
	 * @param roomId
	 * @return
	 */
	public Room findRoomByroomId(String roomId){
		return roomDao.findRoomByroomId(roomId);
	}
	/**
	 * ���ʳƷ�����乺���嵥
	 * @param roomFood
	 * @return
	 */
	public void addFoodToRoom(RoomGoods roomGoods){
		roomGoodsDao.addFoodToRoom(roomGoods);
		goodsDao.updateGoodsCount(roomGoods.getGoodsId(), roomGoods.getOrderCount());
	}
	/**
	 * ���ݵ绰����ݱ�ʶ����ϵͳ��Ϣ
	 * @param tel
	 * @param flag
	 * @return
	 */
	public List<SystemInfo> findinfo(String tel,int flag){
		return systemInfoDao.findinfo(tel, flag);
	}
}
