package com.jis.pojo;
/**
 * 2.包厢类型表的映射类
 * @author shu
 *
 */
public class RoomType {
	//包厢类型编号(主键)
    private int roomTypeId;
    //类型名称
    private String typeName;
    //每小时金额
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
