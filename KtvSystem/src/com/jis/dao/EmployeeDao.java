package com.jis.dao;

import java.util.List;

import com.jis.pojo.Employee;

public interface EmployeeDao {
	/**
	 * 根据员工编号查找员工
	 * @param empId
	 * @return
	 */
	public Employee findEmpByempId(int empId);
	/**
	 * 查找所有员工
	 * @return
	 */
	public List<Employee> findAllEmp();
	/**
	 * 根据原编号删除员工
	 * @param empId
	 */
	public void deleteEmpByempId(int empId);
	/**
	 * 根据员工姓名查找员工
	 * @param empName
	 * @return
	 */
	public List<Employee> searchEmp(String empName);
	/**
	 * 根据员工的电话查找员工
	 * @param Tel
	 * @return
	 */
	public Employee findEmpByEmpTel(String Tel);
}
