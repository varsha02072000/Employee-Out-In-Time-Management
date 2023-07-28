package com.employee.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entities.TimeInfo;

public interface DatewiseReportRepository extends JpaRepository<TimeInfo,Integer> 
{
	List<TimeInfo> findByDate(LocalDate date);
	
	@Query("from TimeInfo where date between :arg1 and :arg2")
	List<TimeInfo> findByDateBetween(@Param("arg1") LocalDate date1,@Param("arg2") LocalDate date2);
}
