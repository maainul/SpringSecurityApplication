package com.SpringSecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class HomeController {
	
	@GetMapping("/home")
	public String getHome() {
		return "index";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
