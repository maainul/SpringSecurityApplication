package com.SpringSecurityApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/home2")
	public String home2() {
		return "index";
	}


}
