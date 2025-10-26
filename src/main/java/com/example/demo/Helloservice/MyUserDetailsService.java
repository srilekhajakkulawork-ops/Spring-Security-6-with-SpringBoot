package com.example.demo.Helloservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Hellorepo.SecurityRepo;
import com.example.demo.model.UserPrincipal;
import com.example.demo.model.Users;
@Service
public class MyUserDetailsService implements UserDetailsService {

	
	private SecurityRepo repo;
	public MyUserDetailsService(SecurityRepo repo) {   // constructor injection
        this.repo = repo;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		
		if(user == null) {
		System.out.println("User not found");
		throw new UsernameNotFoundException("user not found");
		
	}
		return new UserPrincipal(user);
	}	

}
