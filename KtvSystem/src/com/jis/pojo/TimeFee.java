package com.jis.pojo;

import java.util.Date;

/**
 * 3.包厢加价表的映射类
 * @author shu
 *
 */
public class TimeFee {
	//加价时间段id
    private int timeId;
    //开始加价时间
    private Date startAddPrice;
    //结束加价时间
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
