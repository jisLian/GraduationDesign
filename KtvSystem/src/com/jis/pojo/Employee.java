package com.jis.pojo;

import java.util.Date;

/**
 * 16.Ա�����ӳ����
 * @author shu
 *
 */
public class Employee {
	//Ա����ţ�����)
	private int empId;
	//Ա������  
	private String empName;
	//Ա������       
	private String empPwd;
	//Ա���Ա�0��1Ů��  
	private int empSex;
	//Ա���绰����  
	private String empTel;
	//Ա����ݱ�ʶ (0��ǰ̨Ա�� 1�Ƿ���Ա 2����Ա)
	private int empFlag;
	//Ա��סַ  
	private String empAddress;
	//Ա������  
	private Date birthday;
	//Ա����ְ����  
	private Date hire_date;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public int getEmpSex() {
		return empSex;
	}
	public void setEmpSex(int empSex) {
		this.empSex = empSex;
	}
	
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpFlag() {
		return empFlag;
	}
	public void setEmpFlag(int empFlag) {
		this.empFlag = empFlag;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	
}
