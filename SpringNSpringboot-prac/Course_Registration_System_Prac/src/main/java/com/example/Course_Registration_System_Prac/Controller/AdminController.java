package com.example.Course_Registration_System_Prac.Controller;

import com.example.Course_Registration_System_Prac.Model.CourseRegistry;
import com.example.Course_Registration_System_Prac.Model.Users;
import com.example.Course_Registration_System_Prac.Service.CourseService;
import com.example.Course_Registration_System_Prac.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @PostMapping("/add-user")
    public String addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @GetMapping("/get-user")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getEnrolled")
    public List<CourseRegistry> getEnrolled() {
        return courseService.getEnrolled();
    }
}
