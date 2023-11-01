package com.example.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.dto.ResponseDto;
import com.example.blog.model.User;
import com.example.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save 호출");
		userService.signUP(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}

/*
@PostMapping("/api/user/login")
public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
	System.out.println("UserApiController: login 호출");
	User principal = userService.logIn(user);
	if(principal != null) {
		session.setAttribute("principal", principal);
	}
	return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
}
*/