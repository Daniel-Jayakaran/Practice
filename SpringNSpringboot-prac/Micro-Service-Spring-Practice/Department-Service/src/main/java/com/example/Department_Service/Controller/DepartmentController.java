package com.example.Department_Service.Controller;

import com.example.Department_Service.Model.Department;
import com.example.Department_Service.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService deptService;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        return new ResponseEntity<>(deptService.getDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Integer id){
        return new ResponseEntity<>(deptService.getDepartmentById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(deptService.addDepartment(department), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(deptService.updateDepartment(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        return new ResponseEntity<>(deptService.deleteDepartment(id), HttpStatus.ACCEPTED );
    }
}
