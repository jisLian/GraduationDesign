package com.jis.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegistVipForm {
	//注册会员的变量
	private String regName;
	private String regTel;
	private int vipSex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegTel() {
		return regTel;
	}
	public void setRegTel(String regTel) {
		this.regTel = regTel;
	}
	public int getVipSex() {
		return vipSex;
	}
	public void setVipSex(int vipSex) {
		this.vipSex = vipSex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
