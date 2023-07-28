package com.example.taskmanagement.repositories;

import com.example.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User save(User user);

    User findByUsername(String userName);
    User findById(int userId);
}
