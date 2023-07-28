package com.employee.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.TimeInfo;
import com.employee.repositories.DatewiseReportRepository;
import com.employee.repositories.EmpwiseReportRepository;

@Service
public class EmpwiseReportServiceImpl 
{
	@Autowired EmpwiseReportRepository repo;

	public List<TimeInfo> getCurrentDateList(int eid) 
	{
		LocalDate date=LocalDate.now();
		return repo.findByDateAndEid(date,eid);
	}

	
}
