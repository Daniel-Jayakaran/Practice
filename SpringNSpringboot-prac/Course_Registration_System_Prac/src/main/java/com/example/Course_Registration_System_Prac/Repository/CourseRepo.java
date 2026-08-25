package com.example.Course_Registration_System_Prac.Repository;

import com.example.Course_Registration_System_Prac.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
