package com.jis.bean;

public class GoodsInfo {
	private int goodsId;
	private int orderCount;
	private String goodsName;	
	public GoodsInfo(int goodsId, int orderCount, String goodsName) {
		super();
		this.goodsId = goodsId;
		this.orderCount = orderCount;
		this.goodsName = goodsName;
	}
	
	public GoodsInfo() {
		super();
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


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
