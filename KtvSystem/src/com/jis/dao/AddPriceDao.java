package com.jis.dao;

import java.util.List;

import com.jis.pojo.AddPrice;

public interface AddPriceDao {
	/**
	 * ��ʱ��μ۸��޸�
	 */
	public void updateDiscountFeeByTimeId(double fee,int roomTypeId,int timeId);
	
	/**
	 * ���ݷ���id��ʱ���id���Ҿ����ۿ�
	 * @param roomTypeId
	 * @param timeId
	 * @return
	 */
	public AddPrice findDisById(int roomTypeId,int timeId);
	/**
	 * ��ȡ���мӼۼ۸�
	 * @return
	 */
	public List<AddPrice> getAllDiscount();
}
