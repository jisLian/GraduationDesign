package com.jis.pojo;
/**
 * 4.�Ӽ��ۿ۱�
 * @author shu
 *
 */
public class AddPrice {
	//�Ӽ�ʱ��α��(���)
    private TimeFee timeId;
    //�������ͱ��
    private RoomType roomTypeId;
    //�Ӽ��ۿ�
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
