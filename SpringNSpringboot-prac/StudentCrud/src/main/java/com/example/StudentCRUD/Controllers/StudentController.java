package com.example.StudentCRUD.Controllers;

import com.example.StudentCRUD.Services.StudentService;
import com.example.StudentCRUD.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> GetStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{rno}")
    public String getStudentByRno(@PathVariable("rno") int rno){
        return studentService.getStdByRno(rno);
    }

    @PostMapping("students")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "{\n\tAdd-student: Success\n}";
    }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
//        return "{\n\tUpdate-Student: Success\n}";
    }

    @DeleteMapping("students/{rno}")
    // no need to specific PathVariable-Variable name when input parameter name is same as it
    public String deleteStudent(@PathVariable int rno) {
        return studentService.deleteStudent(rno);
    }
}
