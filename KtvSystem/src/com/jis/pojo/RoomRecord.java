package com.jis.pojo;

import java.util.Date;

/**
 * 5.包厢使用记录表映射类
 * @author shu
 *
 */
public class RoomRecord {
	 //包厢号（外键）
     private String roomId;
     //使用开始时间
     private Date startTime;
     //应该结束时间
     private Date endTime;
     //实际结束时间
     private Date actualEndTime;
     //使用的顾客编号
     private int customerId;
     //总的消费金额
     private float cunsumFee;
  
	public RoomRecord() {
		super();
	}
	public RoomRecord(String roomId, Date startTime, Date endTime, Date actualEndTime, int customerId, float cunsumFee) {
		super();
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.actualEndTime = actualEndTime;
		this.customerId = customerId;
		this.cunsumFee = cunsumFee;
	}


	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getActualEndTime() {
		return actualEndTime;
	}
	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getCunsumFee() {
		return cunsumFee;
	}
	public void setCunsumFee(float cunsumFee) {
		this.cunsumFee = cunsumFee;
	}
     
}
