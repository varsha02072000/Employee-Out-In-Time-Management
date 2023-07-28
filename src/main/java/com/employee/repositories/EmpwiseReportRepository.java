package com.employee.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entities.TimeInfo;

public interface EmpwiseReportRepository extends JpaRepository<TimeInfo,Integer> 
{

	@Query("from TimeInfo where date=:arg1 and eid=:arg2")
	List<TimeInfo> findByDateAndEid(@Param("arg1") LocalDate date,@Param("arg2") int eid);
}
