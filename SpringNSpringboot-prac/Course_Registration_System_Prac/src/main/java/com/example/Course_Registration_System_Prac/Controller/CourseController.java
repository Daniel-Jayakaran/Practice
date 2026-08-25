package com.example.Course_Registration_System_Prac.Controller;

import com.example.Course_Registration_System_Prac.Model.Course;
import com.example.Course_Registration_System_Prac.Model.CourseRegistry;
import com.example.Course_Registration_System_Prac.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> availableCourses() {
        return courseService.availableCourses();
    }

    @GetMapping("/courses/getEnrolled")
    public List<CourseRegistry> getEnrolled() {
        return courseService.getEnrolled();
    }

    @PostMapping("/courses/register")
    public String courseRegister(@RequestParam("Name") String Name,
                                 @RequestParam("email") String email,
                                 @RequestParam("courseName") String courseName){
        courseService.enrollCourse(Name, email, courseName);
        return "Congratulation " + Name + " Course Registration Successful for Course: " + courseName;
    }
}
