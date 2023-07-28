package com.employee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.TimeInfo;
import com.employee.repositories.EmployeeRepository;
import com.employee.repositories.InTimeRepository;
import com.employee.services.InTimeService;
import com.employee.utility.TimeUtitliy;

@Service
public class InTimeServiceImpl implements InTimeService 
{
	@Autowired private InTimeRepository repo;
	@Autowired private EmployeeRepository erepo;

	public void updateInTime(int eid) 
	{
		String intime=TimeUtitliy.getCurrentTime();
		TimeInfo timeInfo=repo.getTimeInfo(eid);
		String outtime=timeInfo.getOuttime();
		String totaltime=TimeUtitliy.getTotalTime(intime,outtime);
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		erepo.updateStatus("in",eid);
	}
}
