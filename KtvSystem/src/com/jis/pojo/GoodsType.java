package com.jis.pojo;
/**
 * 14.商品分类表的映射类
 * @author shu
 *
 */
public class GoodsType {
	//商品类别编号
    private int goodstypeId;
    //商品类别名称
    private String goodstypename;
	public int getGoodstypeId() {
		return goodstypeId;
	}
	public void setGoodstypeId(int goodstypeId) {
		this.goodstypeId = goodstypeId;
	}
	public String getGoodstypename() {
		return goodstypename;
	}
	public void setGoodstypename(String goodstypename) {
		this.goodstypename = goodstypename;
	}
    
}
