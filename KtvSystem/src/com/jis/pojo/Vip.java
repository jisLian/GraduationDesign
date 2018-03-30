package com.jis.pojo;

import java.util.Date;

/**
 * 6.会员表的映射类
 * @author shu
 *
 */
public class Vip {
	 //会员编号（外键）
     private int vipId;
     //会员头像
     private String vipHead;
     //会员姓名
     private String vipName;
     //会员密码
     private String vipPwd;
     //会员等级
     private int vipLevel;
     //会员折扣（优惠）
     private float vipDiscount;
     //会员手机号
     private String vipTel;
     //会员生日
     private Date vipBirth;
     //会员性别（0男 1女）
     private int VIPSex;   
     
	
	public Vip(int vipId,String vipName, String vipTel, Date vipBirth, int vIPSex) {
		super();
		this.vipId=vipId;
		this.vipName = vipName;
		this.vipTel = vipTel;
		this.vipBirth = vipBirth;
		VIPSex = vIPSex;
	}
	public Vip() {
		super();
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	
	public String getVipHead() {
		return vipHead;
	}
	public void setVipHead(String vipHead) {
		this.vipHead = vipHead;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getVipPwd() {
		return vipPwd;
	}
	public void setVipPwd(String vipPwd) {
		this.vipPwd = vipPwd;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public float getVipDiscount() {
		return vipDiscount;
	}
	public void setVipDiscount(float vipDiscount) {
		this.vipDiscount = vipDiscount;
	}
	public String getVipTel() {
		return vipTel;
	}
	public void setVipTel(String vipTel) {
		this.vipTel = vipTel;
	}
	public Date getVipBirth() {
		return vipBirth;
	}
	public void setVipBirth(Date vipBirth) {
		this.vipBirth = vipBirth;
	}
	public int getVIPSex() {
		return VIPSex;
	}
	public void setVIPSex(int vIPSex) {
		VIPSex = vIPSex;
	}
     
}
