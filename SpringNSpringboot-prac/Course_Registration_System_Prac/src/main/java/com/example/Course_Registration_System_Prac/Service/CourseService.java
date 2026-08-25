package com.example.Course_Registration_System_Prac.Service;

import com.example.Course_Registration_System_Prac.Model.Course;
import com.example.Course_Registration_System_Prac.Model.CourseRegistry;
import com.example.Course_Registration_System_Prac.Repository.CourseRegistryRepo;
import com.example.Course_Registration_System_Prac.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> availableCourses() {
        return courseRepo.findAll();
    }


    public List<CourseRegistry> getEnrolled() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String Name, String email, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(Name, email, courseName);
        courseRegistryRepo.save(courseRegistry);
    }
}
