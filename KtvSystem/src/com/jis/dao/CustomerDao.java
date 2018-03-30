package com.jis.dao;

import java.util.List;

import com.jis.pojo.Customer;

public interface CustomerDao {
	/**
	 * 添加新的用户
	 * @param c
	 */
	public void AddCustomer(Customer c);	
	/**
	 * 根据用户名查找客户信息
	 * @param name
	 * @return
	 */
	public Customer findCustomerByTel(String tel);	
	/**
	 * 根据用户id查找客户
	 * @param cid
	 * @return
	 */
	public Customer findCustomerById(int cid);
	
	/**
	 * 更新用户电话信息
	 * @param tel
	 * @param customerId
	 */
	public void updateTel(String tel,int customerId);
	/**
	 * 更新顾客姓名
	 * @param customerName
	 * @param customerId
	 */
	public void updateName(String customerName,int customerId);
	/**
	 * 查找所有普通用户
	 * @return
	 */
	public List<Customer> findAllCustomer();
	/**
	 * 根据顾客的编号删除顾客
	 * @param customerId
	 */
	public void deleteCustomerById(int customerId);
}
