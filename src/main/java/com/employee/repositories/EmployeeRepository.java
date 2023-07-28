package com.employee.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	List<Employee> findByStatus(String status);
	
	@Modifying
	@Transactional
	@Query("update Employee set status=:p1 where eid=:p2")
	void updateStatus(@Param("p1") String status,@Param("p2") int eid);
	
	@Query("select e.name from Employee e where e.eid=:arg")
	String getEmployeeName(@Param("arg") int eid);
}
