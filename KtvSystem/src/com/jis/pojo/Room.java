package com.jis.pojo;
/**
 * 1.包厢表的映射类
 * @author shu
 *
 */
public class Room {
	//包厢编号（主键）
    private String roomId;
    //包厢类型编号
    private int roomTypeId;
    //使用标识(0:未使用，1：使用)
    private int useFlag;
    
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public int getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(int useFlag) {
		this.useFlag = useFlag;
	}
    
}
