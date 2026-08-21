package com.example.JPAdemo.Controller;

import com.example.JPAdemo.Model.Student;
import com.example.JPAdemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JpaPrac")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
//        Change List<Student> to ResponseEntity<Object> as we return List
    public ResponseEntity<Object> getAllStudents() {
//        return studentService.getAllStudents();

//        Refactoring DataFlow for Adding ResponseEntity<>
          List<Student> students = studentService.getAllStudents();
          if(students.isEmpty()){
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{rno}")
    public ResponseEntity<Student> getStdByRno(@PathVariable int rno) {
//        return studentService.getStdByRno(rno);

//        Code Change for Adding ResponseEntity<>
          Student st = studentService.getStdByRno(rno);
          if(st == null) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(st, HttpStatus.FOUND);
    }

    @PostMapping("/students")
//        Change String to ResponseEntity<String>
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
//        studentService.addStudent(student);
//        return "{\n\t\"Add-Student Operation\": \"Success\"\n}";

//        Refactoring DataFlow for Adding ResponseEntity<>
          studentService.addStudent(student);
          return new ResponseEntity<>("{\n\t\"Student Created\": \"Student record is " +
                                                "Successfully Created in DB\"\n}", HttpStatus.CREATED);
    }

    @PutMapping("/students")
//        Change String to ResponseEntity<String>
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
//        studentService.updateStudent(student);
//        return "{\n\t\"Student Updation\": \"Success\"\n";

//        Refactoring DataFlow for Adding ResponseEntity<>
          studentService.updateStudent(student);
          return new ResponseEntity<>("{\n\t\"Student Update\": \"Student record with Rno - " +
                                        student.getRno() + " is Successfully Updated in DB\"\n}"
                                            , HttpStatus.OK);
    }

    @DeleteMapping("/students/clear")
//        Change String to ResponseEntity<String>
    public ResponseEntity<String> clearStudents() {
//        studentService.clearStudents();
//        return "{\n\t\"Clearing All Student Operation\": \"Success\"\n}";

//        Refactoring DataFlow for Adding ResponseEntity<>
          studentService.clearStudents();
          return new ResponseEntity<>("{\n\t\"All Student Clear OP\": \"All Student record are "
                                          + "Successfully Deleted in DB\"\n}"
                                              , HttpStatus.OK);
    }

    @DeleteMapping("/students/{rno}")
//        Change String to ResponseEntity<String>
    public ResponseEntity<String> deleteStudentByRno(@PathVariable int rno) {
//        studentService.deleteStudentByRno(rno);
//        return "{\n\t\"Deletion of Student Operation\": \"Success\"\n}";

//        Refactoring DataFlow for Adding ResponseEntity<>
          studentService.deleteStudentByRno(rno);
          return new ResponseEntity<>("{\n\t\"Student Deletion by Roll Number\": \"Student record with Rno - " +
                                        rno + " is Successfully deleted in DB\"\n}"
                                          , HttpStatus.ACCEPTED);
    }

    @GetMapping("/students/technology/{tech}")
//          Change List<Student> to ResponseEntity<Object> as we return List
    public ResponseEntity<Object> findByStudentByTechnology(@PathVariable String tech) {
//          return studentService.getStudentByTechnology(tech);

//          Refactoring DataFlow for Adding ResponseEntity<>
            List<Student> studWithTech = studentService.getStudentByTechnology(tech);
            if(studWithTech.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studWithTech, HttpStatus.OK);
    }

    @GetMapping("/students/filter")
//          Change List<Student> to ResponseEntity<Object> as we return List
    public ResponseEntity<Object> findByStudentByGenderAndTechnology(@Param("gender") String gender,
                                                         @Param("technology") String technology){
//          return studentService.getStudentByGenderAndTechnology(gender, technology);

//          Refactoring DataFlow for Adding ResponseEntity<>
            List<Student> studWGenNTech = studentService.getStudentByGenderAndTechnology(gender, technology);
            if(studWGenNTech.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studWGenNTech, HttpStatus.OK);
    }
}
