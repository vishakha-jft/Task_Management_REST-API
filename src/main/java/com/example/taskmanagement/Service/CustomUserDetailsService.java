package com.example.taskmanagement.Service;

import com.example.taskmanagement.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.taskmanagement.entity.User userdto = userRepo.findByUsername(username);
        UserDetails user = User.withUsername(userdto.getUsername())
                .password(userdto.getPassword())
                .build();

        return user;
    }
}
