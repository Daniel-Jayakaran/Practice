package com.example.SpringSecurityBasicsPrac.Service;

import com.example.SpringSecurityBasicsPrac.Model.UserPrincipal;
import com.example.SpringSecurityBasicsPrac.Model.Users;
import com.example.SpringSecurityBasicsPrac.Repository.MyUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MyUserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepo.getByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrincipal(user);
    }
}
