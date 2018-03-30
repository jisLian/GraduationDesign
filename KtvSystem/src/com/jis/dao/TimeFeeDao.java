package com.jis.dao;

import java.util.Date;
import java.util.List;

import com.jis.pojo.AddPrice;
import com.jis.pojo.TimeFee;

public interface TimeFeeDao {
	/**
	 * �޸ļӼ�ʱ���
	 */
	public void updateTimeRand(Date start,Date end,int timeId);
	/**
	 * ��ȡ���мӼ�ʱ���
	 * @return
	 */
	public List<TimeFee> getAllTimeFee();
	
	/**
	 * ����ʱ��η���
	 * @return
	 */
	public TimeFee findFee();
	/**
	 * ����ʱ���Ų���ʱ���
	 * @param timeId
	 * @return
	 */
	public TimeFee getTimeFeeByTimeId(int timeId);
}
