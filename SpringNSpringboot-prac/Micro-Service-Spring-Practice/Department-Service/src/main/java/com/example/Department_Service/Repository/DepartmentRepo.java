package com.example.Department_Service.Repository;

import com.example.Department_Service.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// extends Jpa Repo to access db

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
