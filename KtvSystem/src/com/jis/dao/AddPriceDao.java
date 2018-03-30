package com.jis.dao;

import java.util.List;

import com.jis.pojo.AddPrice;

public interface AddPriceDao {
	/**
	 * 对时间段价格修改
	 */
	public void updateDiscountFeeByTimeId(double fee,int roomTypeId,int timeId);
	
	/**
	 * 根据房间id和时间段id查找具体折扣
	 * @param roomTypeId
	 * @param timeId
	 * @return
	 */
	public AddPrice findDisById(int roomTypeId,int timeId);
	/**
	 * 获取所有加价价格
	 * @return
	 */
	public List<AddPrice> getAllDiscount();
}
