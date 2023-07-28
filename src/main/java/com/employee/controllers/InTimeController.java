package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.employee.entities.Employee;
import com.employee.services.EmployeeService;
import com.employee.services.InTimeService;

@Controller
@RequestMapping("time-management/intime")
public class InTimeController 
{
	@Autowired private InTimeService inTimeService;
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("")
	public String getEmployeeListView(Model model)
	{
		List<Employee> employeeList=employeeService.getOutList();
		model.addAttribute("elist",employeeList);
		return "time/in/employee-outlist";
	}
	@RequestMapping("update")
	public String updateEmployeeInTime(int eid)
	{
		inTimeService.updateInTime(eid);
		return "time/in/update-success";
	}
}
