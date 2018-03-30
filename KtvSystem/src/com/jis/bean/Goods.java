package com.jis.bean;

public class Goods {
	private int goodId;
	private int goodsCount;
	
	public Goods() {
		super();
	}
	public Goods(int goodId, int goodsCount) {
		super();
		this.goodId = goodId;
		this.goodsCount = goodsCount;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	
}
