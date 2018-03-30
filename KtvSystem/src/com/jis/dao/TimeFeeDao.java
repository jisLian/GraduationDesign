package com.jis.dao;

import java.util.Date;
import java.util.List;

import com.jis.pojo.AddPrice;
import com.jis.pojo.TimeFee;

public interface TimeFeeDao {
	/**
	 * 修改加价时间段
	 */
	public void updateTimeRand(Date start,Date end,int timeId);
	/**
	 * 获取所有加价时间段
	 * @return
	 */
	public List<TimeFee> getAllTimeFee();
	
	/**
	 * 查找时间段分类
	 * @return
	 */
	public TimeFee findFee();
	/**
	 * 根据时间编号查找时间段
	 * @param timeId
	 * @return
	 */
	public TimeFee getTimeFeeByTimeId(int timeId);
}
