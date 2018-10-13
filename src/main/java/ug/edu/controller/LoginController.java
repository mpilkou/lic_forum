package ug.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	private String login() {
		
		return "login-form";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "accessDenied";
	}
	
}
