package com.jis.form;

public class OrderRoomForm {
	//预订包厢的变量
	private String selectedRoom;
	private String vipName;
	private String vipTel;
	private String orderTime;
	private String money;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSelectedRoom() {
		return selectedRoom;
	}
	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getVipTel() {
		return vipTel;
	}
	public void setVipTel(String vipTel) {
		this.vipTel = vipTel;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
}
