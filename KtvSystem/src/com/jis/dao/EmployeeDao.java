package com.jis.dao;

import java.util.List;

import com.jis.pojo.Employee;

public interface EmployeeDao {
	/**
	 * ����Ա����Ų���Ա��
	 * @param empId
	 * @return
	 */
	public Employee findEmpByempId(int empId);
	/**
	 * ��������Ա��
	 * @return
	 */
	public List<Employee> findAllEmp();
	/**
	 * ����ԭ���ɾ��Ա��
	 * @param empId
	 */
	public void deleteEmpByempId(int empId);
	/**
	 * ����Ա����������Ա��
	 * @param empName
	 * @return
	 */
	public List<Employee> searchEmp(String empName);
	/**
	 * ����Ա���ĵ绰����Ա��
	 * @param Tel
	 * @return
	 */
	public Employee findEmpByEmpTel(String Tel);
}
