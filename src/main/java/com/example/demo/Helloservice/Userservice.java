package com.example.demo.Helloservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Hellorepo.SecurityRepo;
import com.example.demo.model.Users;
import org.springframework.security.core.Authentication;



@Service
public class Userservice {
	
	@Autowired
	private SecurityRepo repo;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtservice;
	
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
}

	public String verify(Users user) {
		 Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated())
				return jwtservice.generateToken(user.getUsername());
		
				return "fail";
	}
}
