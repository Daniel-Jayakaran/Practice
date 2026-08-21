package com.example.JPAdemo.Service;

import com.example.JPAdemo.Model.Student;
import com.example.JPAdemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStdByRno(int rno) {
//        return studentRepo.findById(rno).orElseThrow(RuntimeException::new);
         return studentRepo.findById(rno).orElse(null); // Adding Response Entity
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    public void clearStudents() {
        studentRepo.deleteAll();
    }

    public void deleteStudentByRno(int rno) {
        studentRepo.deleteById(rno);
    }

    public List<Student> getStudentByTechnology(String tech) {
        return studentRepo.findByTechnology(tech);
    }

    public List<Student> getStudentByGenderAndTechnology(String gender, String technology) {
        return studentRepo.findByGenderAndTechnology(gender, technology);
    }
}
