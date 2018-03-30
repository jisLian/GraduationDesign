package com.jis.pojo;
/**
 * 13.商品表的映射类
 * @author shu
 *
 */
public class Goods {
	//商品编号
    private int goodsId;
    //商品名称
    private String goodsName;
    //商品价格
    private float goodsPrice;
    //商品图片路径
    private String goodspicture;
    //商品库存
    private int goodscount;
    //商品类别编号
    private GoodsType goodstype;
    
	public Goods() {
		super();
	}
	public Goods(int goodsId, int goodscount) {
		super();
		this.goodsId = goodsId;
		this.goodscount = goodscount;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodspicture() {
		return goodspicture;
	}
	public void setGoodspicture(String goodspicture) {
		this.goodspicture = goodspicture;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	public GoodsType getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(GoodsType goodstype) {
		this.goodstype = goodstype;
	}
	
    
    
}
