package com.example.StudentCRUD.Services;

import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> students  = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "DJ", "Ai"),
                    new Student(2, "DS", "Cybersecurity")
            )
    );

    public List<Student> getStudents() {
        return students;
    }

//  change to Student as Return Type for DB Logic
    public String getStdByRno(int rno) {
//     ArraysList Traversal Logic
        int index = -1;
        boolean found = false;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getRno() == rno){
                found = true;
                index = i;
                break;
            }
        }
        if(!found){
            return "{\n\tStudent not Found: Array out of bound error\n}";
        }else {
            return "{\n\t\"rno\": "
                    + students.get(index).getRno() +
                    "\n\t\"name\": \""
                    + students.get(index).getName() + "\"" +
                    "\n\t\"technology\": \""
                    + students.get(index).getTechnology() + "\"" +
                    "\n}";
        }



//     DB Logic
//        try{
//            return students.get(rno - 1);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String updateStudent(Student student) {
//     ArraysList Traversal Logic
        int index = -1;
        boolean found = false;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getRno() == student.getRno()){
                found = true;
                index = i;
                break;
            }
        }
        if(found){
            students.set(index, student);
            return "{\n\tUpdate-Student: Success\n}";
        }
        else{
            return "{\n\tStudent not Found: Array out of bound error\n}";
        }


//     DB Logic
//        try{
//            int index = student.getRno() - 1;
//            students.set(index, student);
//            return "{\n\tUpdate-Student: Success\n}";
//        } catch (Exception e) {
//            return "{\n\tStudent Not Found Error: " + e + "\n}";
//        }
    }

    public String deleteStudent(int rno) {

//     ArraysList Traversal Logic
        int index = -1;
        boolean found = false;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getRno() == rno){
                found = true;
                index = i;
                break;
            }
        }
        if(found){
            students.remove(index);
            return "{\n\tDelete-Student OP: Success\n}";
        }
        else{
            return "{\n\tStudent not Found: Array out of bound error\n}";
        }


//     DB Logic
//        try {
//            int index = rno - 1;
//            students.remove(index);
//            return "{\n\tDelete-Student-OP: Success\n}";
//        } catch (Exception e) {
//            return "{\n\tStudent Not Found Error: " + e + "\n}";
//        }
    }
}
