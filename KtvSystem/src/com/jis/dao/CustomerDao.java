package com.jis.dao;

import java.util.List;

import com.jis.pojo.Customer;

public interface CustomerDao {
	/**
	 * ����µ��û�
	 * @param c
	 */
	public void AddCustomer(Customer c);	
	/**
	 * �����û������ҿͻ���Ϣ
	 * @param name
	 * @return
	 */
	public Customer findCustomerByTel(String tel);	
	/**
	 * �����û�id���ҿͻ�
	 * @param cid
	 * @return
	 */
	public Customer findCustomerById(int cid);
	
	/**
	 * �����û��绰��Ϣ
	 * @param tel
	 * @param customerId
	 */
	public void updateTel(String tel,int customerId);
	/**
	 * ���¹˿�����
	 * @param customerName
	 * @param customerId
	 */
	public void updateName(String customerName,int customerId);
	/**
	 * ����������ͨ�û�
	 * @return
	 */
	public List<Customer> findAllCustomer();
	/**
	 * ���ݹ˿͵ı��ɾ���˿�
	 * @param customerId
	 */
	public void deleteCustomerById(int customerId);
}
