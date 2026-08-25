package com.example.Course_Registration_System_Prac.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private int courseId;
    private String courseName;
    private String courseInstructor;
    private float courseDuration;
}
