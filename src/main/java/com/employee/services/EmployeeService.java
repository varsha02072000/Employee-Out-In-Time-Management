package com.employee.services;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService 
{
	void saveRecord(Employee employee);
	Employee getRecord(int eid);
	List<Employee> getInList();
	void changeStatus(int eid, String string);
	List<Employee> getOutList();
	List<Employee> getList();
	String getEmployeeName(int eid);
}
