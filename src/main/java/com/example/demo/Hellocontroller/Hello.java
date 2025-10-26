package com.example.demo.Hellocontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Hello {
	
	@GetMapping("/")
	public String greet(HttpServletRequest request)
	{
		return "Srilekha " + request.getSession().getId();
	}

}
