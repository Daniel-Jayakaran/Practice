package com.example.JPAdemo.Controller;

import com.example.JPAdemo.Model.Student;
import com.example.JPAdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "{\n\tAdd-Student Operation: Success\n}";
    }
}
