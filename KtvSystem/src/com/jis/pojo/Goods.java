package com.jis.pojo;
/**
 * 13.��Ʒ���ӳ����
 * @author shu
 *
 */
public class Goods {
	//��Ʒ���
    private int goodsId;
    //��Ʒ����
    private String goodsName;
    //��Ʒ�۸�
    private float goodsPrice;
    //��ƷͼƬ·��
    private String goodspicture;
    //��Ʒ���
    private int goodscount;
    //��Ʒ�����
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
