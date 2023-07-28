package com.employee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("time-management/home")
public class HomeController 
{
	@RequestMapping("")
	public String getHomeView()
	{
		return "home/home-page";
	}
}
