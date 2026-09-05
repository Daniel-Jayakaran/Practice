package com.example.Department_Service.Controller;

import com.example.Department_Service.Model.Department;
import com.example.Department_Service.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService deptService;

    @GetMapping
    public List<Department> getDepartments() {
        return deptService.getDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Integer id){
        return deptService.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return deptService.addDepartment(department);
    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department department) {
        return deptService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        return deptService.deleteDepartment(id);
    }
}
