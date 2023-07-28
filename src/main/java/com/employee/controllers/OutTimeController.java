package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;
import com.employee.services.EmployeeService;
import com.employee.services.OutTimeService;

@Controller
@RequestMapping("time-management/outtime")
public class OutTimeController 
{
	@Autowired private OutTimeService outTimeService;
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("")
	public String getEmployeeListView(Model model)
	{
		List<Employee> employeeList=employeeService.getInList();
		model.addAttribute("elist",employeeList);
		return "time/out/employee-inlist";
	}
	@RequestMapping("record")
	public String recordEmployeeOutTime(TimeInfo timeInfo)
	{
		outTimeService.recordOutTime(timeInfo);
		return "time/out/record-success";
	}
}
