package com.employee.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepository;
import com.employee.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;

	public void saveRecord(Employee employee) 
	{
		employee.setStatus("in");
		employeeRepository.save(employee);
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.findById(eid).orElse(null);
	}
	public List<Employee> getInList() 
	{
		return employeeRepository.findByStatus("in");
	}
	public void changeStatus(int eid, String status) 
	{
		employeeRepository.updateStatus(status,eid);
	}
	public List<Employee> getOutList() 
	{
		return employeeRepository.findByStatus("out");
	}
	public List<Employee> getList() 
	{
		return employeeRepository.findAll();
	}
	public String getEmployeeName(int eid) 
	{
		return employeeRepository.getEmployeeName(eid);
	}
}
