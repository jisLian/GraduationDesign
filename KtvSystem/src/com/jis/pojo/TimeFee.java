package com.jis.pojo;

import java.util.Date;

/**
 * 3.����Ӽ۱��ӳ����
 * @author shu
 *
 */
public class TimeFee {
	//�Ӽ�ʱ���id
    private int timeId;
    //��ʼ�Ӽ�ʱ��
    private Date startAddPrice;
    //�����Ӽ�ʱ��
    private Date endAddprice;
	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	public Date getStartAddPrice() {
		return startAddPrice;
	}
	public void setStartAddPrice(Date startAddPrice) {
		this.startAddPrice = startAddPrice;
	}
	public Date getEndAddprice() {
		return endAddprice;
	}
	public void setEndAddprice(Date endAddprice) {
		this.endAddprice = endAddprice;
	}
    
}
