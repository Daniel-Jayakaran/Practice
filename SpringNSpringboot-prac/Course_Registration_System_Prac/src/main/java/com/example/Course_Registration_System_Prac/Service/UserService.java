package com.example.Course_Registration_System_Prac.Service;

import com.example.Course_Registration_System_Prac.Model.Users;
import com.example.Course_Registration_System_Prac.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

    @Autowired
    UserDetailsRepo userDetailsRepo;

    public String addUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
        return "{\n\t\"Adding User to DB\": \"Success\"\n}";
    }

    public List<Users> getUsers() {
        return userDetailsRepo.findAll();
    }

}
