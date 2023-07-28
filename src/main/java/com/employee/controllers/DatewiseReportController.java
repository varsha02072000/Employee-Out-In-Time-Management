package com.employee.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entities.TimeInfo;
import com.employee.services.impl.DatewiseReportServiceImpl;

@Controller
@RequestMapping("time-management/report")
public class DatewiseReportController 
{
	@Autowired private DatewiseReportServiceImpl service;
	
	@RequestMapping("datewise")
	public String getDateChoiceView(Model model)
	{
		model.addAttribute("cdate",LocalDate.now());
		return "reports/datewise/choose-date";
	}
	@RequestMapping("current-date")
	public String getCurrentDateReport(Model model)
	{
		List<TimeInfo> list=service.getCurrentDateList();
		model.addAttribute("elist",list);
		return "reports/datewise/current-date";
	}
	@RequestMapping("any-date")
	public String getAnyDateReport(Model model,String date)
	{
		List<TimeInfo> list=service.getAnyDateList(date);
		model.addAttribute("elist",list);
		model.addAttribute("date",date);
		return "reports/datewise/any-date";
	}
	@RequestMapping("date-between")
	public String getDateBetweenReport(Model model,String date1,String date2)
	{
		List<TimeInfo> list=service.getDateBetweenList(date1,date2);
		model.addAttribute("elist",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "reports/datewise/date-between";
	}
}
