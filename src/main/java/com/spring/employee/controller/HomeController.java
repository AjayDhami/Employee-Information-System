package com.spring.employee.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "Application is working and today's date is: " + new Date();
	}
}
