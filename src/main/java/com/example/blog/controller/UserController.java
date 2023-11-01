package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		// /WEB-INF/views/user/joinForm.jsp
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		// /WEB-INF/views/user/loginForm.jsp
		return "user/loginForm";
	}
}
