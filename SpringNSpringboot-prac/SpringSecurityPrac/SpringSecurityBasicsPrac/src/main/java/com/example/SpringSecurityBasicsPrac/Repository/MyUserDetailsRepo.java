package com.example.SpringSecurityBasicsPrac.Repository;


import com.example.SpringSecurityBasicsPrac.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserDetailsRepo extends JpaRepository<Users, Integer> {
    Users getByUsername(String username);
}
