package com.example.JPAdemo.Repository;

import com.example.JPAdemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    // Must do extends JPARepository
}
