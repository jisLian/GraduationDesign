package com.jis.dao;

import java.util.List;

import com.jis.pojo.GoodsType;

public interface GoodsTypeDao {
	/**
	 * ��ѯ����ʳƷ�ķ���
	 * @return
	 */
	public List<GoodsType> findGoodsTypes();
	/**
	 * ������Ʒ���͵ı�Ų�����Ʒ����
	 * @return
	 */
	public GoodsType findGoodsTypeByGoodsTypeId();
	/**
	 * �����Ʒ����
	 * @param GoodstypeName
	 */
	public void addGoodsType(String GoodstypeName);
	/**
	 * ɾ����Ʒ����
	 * @param goodsTypeId
	 */
	public void deleteGoodsType(int goodsTypeId);
}
