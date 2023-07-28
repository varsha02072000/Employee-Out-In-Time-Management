package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entities.TimeInfo;

public interface InTimeRepository extends JpaRepository<TimeInfo,Integer> 
{
	@Query("from TimeInfo where eid=:p1 and intime='Not in yet'")
	TimeInfo getTimeInfo(@Param("p1") int eid);
}
