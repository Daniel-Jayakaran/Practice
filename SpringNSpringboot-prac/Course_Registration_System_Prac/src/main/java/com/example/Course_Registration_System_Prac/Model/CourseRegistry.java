package com.example.Course_Registration_System_Prac.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int rno;
    private String Name;
    private String email;
    private String courseName;

    public CourseRegistry(String Name, String email, String courseName) {
        this.Name = Name;
        this.email = email;
        this.courseName = courseName;
    }
}
