package com.jis.pojo;
/**
 * 2.�������ͱ��ӳ����
 * @author shu
 *
 */
public class RoomType {
	//�������ͱ��(����)
    private int roomTypeId;
    //��������
    private String typeName;
    //ÿСʱ���
    private int perFee;
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getPerFee() {
		return perFee;
	}
	public void setPerFee(int perFee) {
		this.perFee = perFee;
	}
    
}
