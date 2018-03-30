package com.jis.bean;

import java.util.List;

public class RoomGoodsList {
	private String roomId;
	private List<GoodsInfo> roomGoodsList;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public List<GoodsInfo> getRoomGoodsList() {
		return roomGoodsList;
	}
	public void setRoomGoodsList(List<GoodsInfo> roomGoodsList) {
		this.roomGoodsList = roomGoodsList;
	}
	public RoomGoodsList() {
		super();
	}
	public RoomGoodsList(String roomId, List<GoodsInfo> roomGoodsList) {
		super();
		this.roomId = roomId;
		this.roomGoodsList = roomGoodsList;
	}
	
	
}
