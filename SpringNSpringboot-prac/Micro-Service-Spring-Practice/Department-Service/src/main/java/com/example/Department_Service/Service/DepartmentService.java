package com.example.Department_Service.Service;

import com.example.Department_Service.Model.Department;
import com.example.Department_Service.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo deptRepo;

    public List<Department> getDepartments() {
        return deptRepo.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id) {
        return deptRepo.findById(id);
    }

    public Department addDepartment(Department department) {
        return deptRepo.save(department);
    }

    public Department updateDepartment(Department department) {
        return deptRepo.save(department);
    }

    public String deleteDepartment(Integer id){
        deptRepo.deleteById(id);
        return "{\n\t\"Delete Department\": \"Success\"\n}";
    }
}
