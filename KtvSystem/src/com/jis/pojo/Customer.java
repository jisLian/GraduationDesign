package com.jis.pojo;
/**
 * 7.��ͨ�˿ͱ��ӳ����
 * @author shu
 *
 */
public class Customer {
	//�˿ͱ�ţ�������
    private int customerId;
    //�˿�����
    private String customerName;
    //�˿��ֻ���
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
