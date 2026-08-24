package com.example.GetNPostReqContFrontEndSpringCORS.Service;

import com.example.GetNPostReqContFrontEndSpringCORS.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                new Student(1, "Daniel", "AI/ML"),
                new Student(2, "Mike", "Cyber"),
                new Student(33, "Chris", "BlockChain")
            )
    );

    public List<Student> getAllStudent() {
        return students;
    }

    public void addStudent(int rno, String name, String technology) {
        Student student = new Student(rno, name, technology);
        students.add(student);
    }
}
