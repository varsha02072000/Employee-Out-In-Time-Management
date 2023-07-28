package com.employee.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.TimeInfo;
import com.employee.repositories.DatewiseReportRepository;

@Service
public class DatewiseReportServiceImpl 
{
	@Autowired DatewiseReportRepository repo;

	public List<TimeInfo> getCurrentDateList() 
	{
		return repo.findByDate(LocalDate.now());
	}
	public List<TimeInfo> getAnyDateList(String date) 
	{
		LocalDate ldate=LocalDate.parse(date);
		return repo.findByDate(ldate);
	}
	public List<TimeInfo> getDateBetweenList(String date1, String date2) 
	{
		LocalDate ldate1=LocalDate.parse(date1);
		LocalDate ldate2=LocalDate.parse(date2);
		return repo.findByDateBetween(ldate1,ldate2);
	}
}
