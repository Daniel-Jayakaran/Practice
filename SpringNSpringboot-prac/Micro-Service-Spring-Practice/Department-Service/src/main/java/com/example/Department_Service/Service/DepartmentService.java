package com.example.Department_Service.Service;

import com.example.Department_Service.Exceptions.DepartmentNotFoundException;
import com.example.Department_Service.Model.Department;
import com.example.Department_Service.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Department_Service.Exceptions.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo deptRepo;

    public List<Department> getDepartments() {
        return deptRepo.findAll();
    }

    // Throwing Self - Defined DepartmentNotFound Error

    public Optional<Department> getDepartmentById(Integer id) {
        Optional<Department> dept = deptRepo.findById(id);
        if(dept.isEmpty()){
            throw new DepartmentNotFoundException("{\n\t\"Department Not Found with given id\": " + id + "\n}");
        }
        return Optional.of(dept.get());
    }

    public Department addDepartment(Department department) {
        return deptRepo.save(department);
    }


    // Department Updation Services

    public Department updateDepartment(Department department) {
        return deptRepo.save(department);
    }

    // Department Deletions services

    public String deleteDepartment(Integer id){
        deptRepo.deleteById(id);
        return "{\n\t\"Delete Department\": \"Success\"\n}";
    }
}
