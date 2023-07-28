package com.employee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

@Controller
@RequestMapping("time-management/employee")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("add")
	public String getAddEmployeeView()
	{
		return "employee/add-employee";
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee employee,Model model)
	{
		int eid=employee.getEid();
		Employee employee1=employeeService.getRecord(eid);
		if(employee1!=null)
		{
			model.addAttribute("msg1","Employee with id "+eid+" already exists");
			return "employee/add-employee";
		}
		employeeService.saveRecord(employee);
		model.addAttribute("msg","Employee record has been added");
		return "employee/add-employee";
	}
	@RequestMapping("details")
	public String getEmployeeDetails(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		model.addAttribute("employee",employee);
		return "employee/employee-details";
	}
}
