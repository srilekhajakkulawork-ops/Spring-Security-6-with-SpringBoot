package com.example.demo.Hellorepo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;


public interface SecurityRepo extends JpaRepository<Users, Integer>{


	Users findByUsername(String username);
	

}
