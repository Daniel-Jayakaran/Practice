package com.example.Student_Service.Service;

import com.example.Student_Service.Model.Student;
import com.example.Student_Service.Repository.StudentRepo;
import com.example.Student_Service.Exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> getStudent(Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student not found with id - " + id);
        }
        return student;
    }
}
