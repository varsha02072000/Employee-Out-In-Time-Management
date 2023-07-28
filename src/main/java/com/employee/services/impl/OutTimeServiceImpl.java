package com.employee.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.TimeInfo;
import com.employee.repositories.EmployeeRepository;
import com.employee.repositories.OutTimeRepository;
import com.employee.services.EmployeeService;
import com.employee.services.OutTimeService;
import com.employee.utility.TimeUtitliy;

@Service
public class OutTimeServiceImpl implements OutTimeService 
{
	@Autowired private OutTimeRepository repo;
	@Autowired private EmployeeService employeeService;

	public void recordOutTime(TimeInfo timeInfo) 
	{
		timeInfo.setOuttime(TimeUtitliy.getCurrentTime());
		timeInfo.setIntime("Not in yet");
		timeInfo.setTotaltime("Not applicable");
		timeInfo.setDate(LocalDate.now());
		repo.save(timeInfo);
		employeeService.changeStatus(timeInfo.getEid(),"out");
	}
}
