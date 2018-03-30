package com.jis.dao;

import java.util.List;

import com.jis.pojo.RoomGoods;

public interface RoomGoodsDao {
	/**
	 * ���ʳƷ�����乺���嵥
	 * @param roomFood
	 * @return
	 */
	public void addFoodToRoom(RoomGoods roomGoods);
	public List<RoomGoods> findCountById(String roomId,int foodId);
	/**
	 * �ӵ�
	 * @param roomId
	 */
	public void acceptCaseById(String roomId);
}
