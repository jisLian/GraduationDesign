package com.jis.pojo;

import java.util.Date;

/**
 * 5.����ʹ�ü�¼��ӳ����
 * @author shu
 *
 */
public class RoomRecord {
	 //����ţ������
     private String roomId;
     //ʹ�ÿ�ʼʱ��
     private Date startTime;
     //Ӧ�ý���ʱ��
     private Date endTime;
     //ʵ�ʽ���ʱ��
     private Date actualEndTime;
     //ʹ�õĹ˿ͱ��
     private int customerId;
     //�ܵ����ѽ��
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
