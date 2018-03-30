package com.jis.pojo;
/**
 * 10.风格类型表的映射类
 * @author shu
 *
 */
public class StyleType {
	//类型编号
    private int styleTypeId;
    //歌曲类型（风格)
    private String styleTypeName;
	public int getStyleTypeId() {
		return styleTypeId;
	}
	public void setStyleTypeId(int styleTypeId) {
		this.styleTypeId = styleTypeId;
	}
	public String getStyleTypeName() {
		return styleTypeName;
	}
	public void setStyleTypeName(String styleTypeName) {
		this.styleTypeName = styleTypeName;
	}
    
}
