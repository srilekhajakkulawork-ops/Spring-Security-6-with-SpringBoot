package com.example.demo.Hellocontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Studentcontroller {
	
	
	private List<Student> stud = new ArrayList<>(List.of(
			new Student(1, "Srilekha", "Dekalb"),
			new Student(2, "Ganesh", "Hyb")));
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return stud;
	}
	@GetMapping("/csrf-Token")
	public CsrfToken getcsrf(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student){
		stud.add(student);
		return student;
		}
	}
