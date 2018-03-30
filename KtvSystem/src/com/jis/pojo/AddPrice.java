package com.jis.pojo;
/**
 * 4.加价折扣表
 * @author shu
 *
 */
public class AddPrice {
	//加价时间段编号(外键)
    private TimeFee timeId;
    //包厢类型编号
    private RoomType roomTypeId;
    //加价折扣
    private float discountPrice;
	
	public TimeFee getTimeId() {
		return timeId;
	}
	public void setTimeId(TimeFee timeId) {
		this.timeId = timeId;
	}
	public RoomType getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(RoomType roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
    
}
