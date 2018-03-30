package com.jis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jis.form.AddGoodsInfo;
import com.jis.pojo.Goods;

public interface GoodsDao {
	
	/**
	 * 获取取所有商品
	 * @return
	 */
	public List<Goods> findAllGoods(int pageCode);
	/**
	 * 根据类型查找对应的商品
	 * @param typeId
	 * @return
	 */
	public List<Goods> findGoodsByTypeId(int typeId,int pageCode);
	/**
	 * 获取所有商品数量
	 * @return
	 */
	public int findAllGoodsCount();
	/**
	 * 根据类型查找对应的商品数量
	 * @param typeId
	 * @return
	 */
	public int findGoodsCountByTypeId(int typeId);
	/**
	 * 根据房间编号查找对应的食物
	 * @param roomId
	 * @return
	 */
	public List<Goods> findGoodsBygoodsId(String roomId);
	/**
	 * 根据房间号计算房间食物消费总价
	 * @param roomId
	 * @return
	 */
	public float countGoodsFee(String roomId);
	/**
	 * 搜索商品
	 * @param searchContent
	 * @return
	 */
	public List<Goods> searchGoods(String searchContent);
	/**
	 * 添加商品
	 * @param addGoodsInfo
	 */
	public void addGoods(AddGoodsInfo addGoodsInfo);
	/**
	 * 根据商品编号删除商品
	 * @param goodsId
	 */
	public void deleteGoods(int goodsId);
	/**
	 * 根据商品类型编号删除商品
	 * @param goodsTypeId
	 */
	public void deleteGoodsByTypeId(int goodsTypeId);
	/**
	 * 修改商品的信息
	 */
	public void updateGoodsInfo(@Param("goodsId")int goodsId,
			
			@Param("goodsName")String goodsName,
			@Param("goodsPrice")float goodsPrice,
			@Param("goodsCount")int goodsCount,
			@Param("flag")int flag);
	/**
	 * 根据商品编号更新商品库存
	 * @param goodsId
	 * @param goodsCount
	 */
	public void updateGoodsCount(int goodsId,int goodsCount);
}
