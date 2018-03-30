package com.jis.pojo;
/**
 * 7.普通顾客表的映射类
 * @author shu
 *
 */
public class Customer {
	//顾客编号（主键）
    private int customerId;
    //顾客姓名
    private String customerName;
    //顾客手机号
    private String customerTel;
    
	public Customer() {
		super();
	}
	public Customer(String customerName, String customerTel) {
		super();
		this.customerName = customerName;
		this.customerTel = customerTel;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
    
}
