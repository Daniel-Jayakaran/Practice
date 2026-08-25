package com.example.Course_Registration_System_Prac.Repository;

import com.example.Course_Registration_System_Prac.Model.CourseRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry, Integer> {

}
