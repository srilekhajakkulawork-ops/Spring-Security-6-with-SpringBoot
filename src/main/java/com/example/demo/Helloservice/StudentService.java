package com.example.demo.Helloservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentService {

    private final List<Student> stud = new ArrayList<>(
        List.of(
            new Student(1, "Srilekha", "Dekalb"),
            new Student(2, "Ganesh", "Hyb")
        )
    );

    public List<Student> getAll() {
        return stud;
    }

    public Student add(Student s) {
        stud.add(s);
        return s;
    }
}