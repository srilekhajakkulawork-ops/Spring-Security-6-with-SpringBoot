package com.example.demo.Hellocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Helloservice.Userservice;
import com.example.demo.model.Users;

@RestController
public class UserController {
	
	@Autowired
	private Userservice service;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
	return service.register(user);
}
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return service.verify(user);
	}
}
