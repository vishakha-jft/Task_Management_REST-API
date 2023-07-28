package com.example.taskmanagement.Service;

import com.example.taskmanagement.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User findByUsername(String userName);
    User findById(int userId);

    List <User> findAll();
}
