package com.jis.pojo;

import java.util.Date;

/**
 * 15.���Ṻ���嵥��ӳ����
 * @author shu
 *
 */
public class RoomGoods {
	//������
    private String roomId;
    //��Ʒ���
    private int goodsId;
    //��Ʒ����	
    private int orderCount;
    //�µ�ʱ��
    private Date oderTime;
    
	public RoomGoods() {
		super();
	}
	
	public RoomGoods(String roomId, int goodsId, int orderCount, Date oderTime) {
		super();
		this.roomId = roomId;
		this.goodsId = goodsId;
		this.orderCount = orderCount;
		this.oderTime = oderTime;
	}

	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Date getOderTime() {
		return oderTime;
	}
	public void setOderTime(Date oderTime) {
		this.oderTime = oderTime;
	}
    
}
