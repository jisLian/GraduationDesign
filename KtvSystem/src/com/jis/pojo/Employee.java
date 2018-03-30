package com.jis.pojo;

import java.util.Date;

/**
 * 16.员工表的映射类
 * @author shu
 *
 */
public class Employee {
	//员工编号（主键)
	private int empId;
	//员工姓名  
	private String empName;
	//员工密码       
	private String empPwd;
	//员工性别（0男1女）  
	private int empSex;
	//员工电话号码  
	private String empTel;
	//员工身份标识 (0是前台员工 1是服务员 2管理员)
	private int empFlag;
	//员工住址  
	private String empAddress;
	//员工生日  
	private Date birthday;
	//员工入职日期  
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
