package com.example.GetNPostReqContFrontEndSpringCORS.Controller;

import com.example.GetNPostReqContFrontEndSpringCORS.Model.Student;
import com.example.GetNPostReqContFrontEndSpringCORS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:5500/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/students/add")
    public void addStudent(@RequestParam("rno") int rno,
                           @RequestParam("name") String name,
                           @RequestParam("technology") String technology) {
        studentService.addStudent(rno, name, technology);
    }
}
