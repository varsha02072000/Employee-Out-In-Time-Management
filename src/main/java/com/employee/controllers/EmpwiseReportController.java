package com.employee.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.employee.entities.Employee;
import com.employee.entities.TimeInfo;
import com.employee.services.EmployeeService;
import com.employee.services.impl.EmpwiseReportServiceImpl;

@Controller
@RequestMapping("time-management/report")
public class EmpwiseReportController 
{
	@Autowired private EmpwiseReportServiceImpl service;
	@Autowired private EmployeeService employeeService;
	
	@RequestMapping("empwise")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "reports/empwise/employee-list";
	}
	@RequestMapping("empwise/choice")
	public String getChoice(Model model,int eid)
	{
		String name=employeeService.getEmployeeName(eid);
		System.out.println(name);
		model.addAttribute("name",name);
		model.addAttribute("eid",eid);
		return "reports/empwise/choose-date";
	}
	@RequestMapping("empwise/current-date")
	public String getCurrentDateReport(Model model,int eid)
	{
		List<TimeInfo> list=service.getCurrentDateList(eid);
		model.addAttribute("elist",list);
		return "reports/empwise/current-date";
	}
}
