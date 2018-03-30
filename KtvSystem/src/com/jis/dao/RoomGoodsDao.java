package com.jis.dao;

import java.util.List;

import com.jis.pojo.RoomGoods;

public interface RoomGoodsDao {
	/**
	 * 添加食品到房间购物清单
	 * @param roomFood
	 * @return
	 */
	public void addFoodToRoom(RoomGoods roomGoods);
	public List<RoomGoods> findCountById(String roomId,int foodId);
	/**
	 * 接单
	 * @param roomId
	 */
	public void acceptCaseById(String roomId);
}
