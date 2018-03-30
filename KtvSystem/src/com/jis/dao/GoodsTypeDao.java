package com.jis.dao;

import java.util.List;

import com.jis.pojo.GoodsType;

public interface GoodsTypeDao {
	/**
	 * 查询所有食品的分类
	 * @return
	 */
	public List<GoodsType> findGoodsTypes();
	/**
	 * 根据商品类型的编号查找商品类型
	 * @return
	 */
	public GoodsType findGoodsTypeByGoodsTypeId();
	/**
	 * 添加商品分类
	 * @param GoodstypeName
	 */
	public void addGoodsType(String GoodstypeName);
	/**
	 * 删除商品分类
	 * @param goodsTypeId
	 */
	public void deleteGoodsType(int goodsTypeId);
}
