package com.example.taskmanagement.Service.implementation;

import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repositories.UserRepo;
import com.example.taskmanagement.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements UserService {
    private UserRepo UserRepo;

    public userServiceImpl(UserRepo UserRepository) {
        super();
        this.UserRepo = UserRepository;
    }

    @Override
    public User save(User user) {
        return UserRepo.save(user);
    }

    @Override
    public User findByUsername(String userName) {
        return UserRepo.findByUsername(userName);
    }

    @Override
    public User findById(int userId) {
        return UserRepo.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return UserRepo.findAll();
    }
}
