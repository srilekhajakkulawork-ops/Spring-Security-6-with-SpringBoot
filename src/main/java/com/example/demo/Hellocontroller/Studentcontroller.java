package com.example.demo.Hellocontroller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.Helloservice.StudentService;

@RestController
@RequestMapping("/api")
public class Studentcontroller {

    private final StudentService studentService;

    public Studentcontroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAll();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }
}