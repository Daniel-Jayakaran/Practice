package com.example.SpringSecurityBasicsPrac.Controller;

import com.example.SpringSecurityBasicsPrac.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Daniel", "Ai"),
            new Student(2, "Mike", "BlockChain")
    ));


    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public String addStudents(@RequestBody Student student) {
        students.add(student);
        return "{\n\t\"Student Add\": \"Success\"\n}";
    }
}
