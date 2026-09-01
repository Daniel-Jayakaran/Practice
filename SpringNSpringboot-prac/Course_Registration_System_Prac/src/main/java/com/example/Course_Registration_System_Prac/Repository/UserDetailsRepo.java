package com.example.Course_Registration_System_Prac.Repository;

import com.example.Course_Registration_System_Prac.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
    Users getByUsername(String username);
}
