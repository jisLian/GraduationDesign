package com.jis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jis.form.AddGoodsInfo;
import com.jis.pojo.Goods;

public interface GoodsDao {
	
	/**
	 * ��ȡȡ������Ʒ
	 * @return
	 */
	public List<Goods> findAllGoods(int pageCode);
	/**
	 * �������Ͳ��Ҷ�Ӧ����Ʒ
	 * @param typeId
	 * @return
	 */
	public List<Goods> findGoodsByTypeId(int typeId,int pageCode);
	/**
	 * ��ȡ������Ʒ����
	 * @return
	 */
	public int findAllGoodsCount();
	/**
	 * �������Ͳ��Ҷ�Ӧ����Ʒ����
	 * @param typeId
	 * @return
	 */
	public int findGoodsCountByTypeId(int typeId);
	/**
	 * ���ݷ����Ų��Ҷ�Ӧ��ʳ��
	 * @param roomId
	 * @return
	 */
	public List<Goods> findGoodsBygoodsId(String roomId);
	/**
	 * ���ݷ���ż��㷿��ʳ�������ܼ�
	 * @param roomId
	 * @return
	 */
	public float countGoodsFee(String roomId);
	/**
	 * ������Ʒ
	 * @param searchContent
	 * @return
	 */
	public List<Goods> searchGoods(String searchContent);
	/**
	 * �����Ʒ
	 * @param addGoodsInfo
	 */
	public void addGoods(AddGoodsInfo addGoodsInfo);
	/**
	 * ������Ʒ���ɾ����Ʒ
	 * @param goodsId
	 */
	public void deleteGoods(int goodsId);
	/**
	 * ������Ʒ���ͱ��ɾ����Ʒ
	 * @param goodsTypeId
	 */
	public void deleteGoodsByTypeId(int goodsTypeId);
	/**
	 * �޸���Ʒ����Ϣ
	 */
	public void updateGoodsInfo(@Param("goodsId")int goodsId,
			
			@Param("goodsName")String goodsName,
			@Param("goodsPrice")float goodsPrice,
			@Param("goodsCount")int goodsCount,
			@Param("flag")int flag);
	/**
	 * ������Ʒ��Ÿ�����Ʒ���
	 * @param goodsId
	 * @param goodsCount
	 */
	public void updateGoodsCount(int goodsId,int goodsCount);
}
