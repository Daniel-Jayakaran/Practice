package com.example.JPAdemo.Repository;

import com.example.JPAdemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    // Must do extends JPARepository

    List<Student> findByTechnology(String tech);

    @Query(nativeQuery = true,
            value = "SELECT * FROM student WHERE gender =:gender AND technology =:technology")
    List<Student> findByGenderAndTechnology(@Param("gender") String gender,
                                                  @Param("technology") String technology);
}
