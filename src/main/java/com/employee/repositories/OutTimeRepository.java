package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.TimeInfo;

public interface OutTimeRepository extends JpaRepository<TimeInfo,Integer> 
{
}
