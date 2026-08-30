package com.example.SpringSecurityBasicsPrac.Service;

import com.example.SpringSecurityBasicsPrac.Model.Users;
import com.example.SpringSecurityBasicsPrac.Repository.MyUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    MyUserDetailsRepo userDetailsRepo;

    public String addUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
        return "{\n\t\"User Added in DB\": \"Success\"\n}";
    }

    public List<Users> getUsers() {
        return userDetailsRepo.findAll();
    }
}
