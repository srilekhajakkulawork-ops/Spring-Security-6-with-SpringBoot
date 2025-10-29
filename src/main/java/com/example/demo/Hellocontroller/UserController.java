package com.example.demo.Hellocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Helloservice.Userservice;
import com.example.demo.model.Users;


@RestController
@RequestMapping("/api/auth")  
public class UserController {

    @Autowired
    private Userservice service;

  
    @PostMapping("/register")
    public String register(Users user, RedirectAttributes ra) {
      service.register(user);
      ra.addFlashAttribute("msg", "Account created. Please log in.");
      return "redirect:/login";
    }


    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome! You are logged in successfully.";
    }
}
