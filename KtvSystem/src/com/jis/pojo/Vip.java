package com.jis.pojo;

import java.util.Date;

/**
 * 6.��Ա���ӳ����
 * @author shu
 *
 */
public class Vip {
	 //��Ա��ţ������
     private int vipId;
     //��Աͷ��
     private String vipHead;
     //��Ա����
     private String vipName;
     //��Ա����
     private String vipPwd;
     //��Ա�ȼ�
     private int vipLevel;
     //��Ա�ۿۣ��Żݣ�
     private float vipDiscount;
     //��Ա�ֻ���
     private String vipTel;
     //��Ա����
     private Date vipBirth;
     //��Ա�Ա�0�� 1Ů��
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
