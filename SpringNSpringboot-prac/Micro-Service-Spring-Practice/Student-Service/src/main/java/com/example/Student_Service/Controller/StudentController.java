package com.example.Student_Service.Controller;

import com.example.Student_Service.Model.Student;
import com.example.Student_Service.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    // object reference for StudentService
    @Autowired
    private StudentService studentService;


    // Get Request for Fetching all Students from DB

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // Get Request for fetching a single student from db

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.ACCEPTED);
    }

    // Post Request to add a Student in DB

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity(studentService.addStudent(student), HttpStatus.CREATED);
    }
}
