package com.example.SpringSecurityBasicsPrac.Controller;


import com.example.SpringSecurityBasicsPrac.Model.Users;
import com.example.SpringSecurityBasicsPrac.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/getUsers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/admin/addUser")
    public String addUser(@RequestBody Users user) {
        System.out.println("Received username: " + user.getUsername());
        System.out.println("Received password: " + user.getPassword());
        return userService.addUser(user);
    }
}
