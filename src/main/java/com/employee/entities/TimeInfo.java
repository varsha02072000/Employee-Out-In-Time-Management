package com.employee.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TimeInfo 
{
	@Id
	@GeneratedValue(generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq",initialValue = 1111,allocationSize = 1)
	private int id;
	private int eid;
	private String outtime;
	private String intime;
	private String totaltime;
	private LocalDate date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
