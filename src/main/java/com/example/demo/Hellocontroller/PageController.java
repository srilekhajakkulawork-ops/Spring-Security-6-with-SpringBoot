package com.example.demo.Hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Helloservice.StudentService;

@Controller
public class PageController {

    private final StudentService studentService;

    public PageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping("/register-page")
    public String registerPage() { return "register"; }

    @GetMapping("/students")
    public String studentsPage(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "students";  // renders templates/students.html
    }
}