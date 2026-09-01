package com.example.Course_Registration_System_Prac.Service;

import com.example.Course_Registration_System_Prac.Model.Users;
import com.example.Course_Registration_System_Prac.Repository.UserDetailsRepo;
import com.example.Course_Registration_System_Prac.Model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepo.getByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrinciple(user);
    }
}
