package com.example.taskmanagement.controller;

import com.example.taskmanagement.Service.SendGridService;
import com.example.taskmanagement.Service.UserService;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repositories.TaskRepo;
import com.example.taskmanagement.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
//    @Autowired
//    UserRepo userRepo;

    @Autowired
    private UserService userservice;
    @Autowired
    TaskRepo taskRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    SendGridService sendGridService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userservice.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<User> allUser() {
        List<User> userList = userservice.findAll();
        return userList;
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        User user = userservice.findById(userId);
        return user;
    }

    @GetMapping(value = "/{userId}/tasks")
    public List<Task> userTasks(@PathVariable("userId") User userId,Model model) {
        List<Task> taskList = taskRepo.findByUserId(userId);
        model.addAttribute("taskList",taskList);
        return taskList;
    }
    @PutMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<Void> assignTasks(@PathVariable("taskId") int taskId, @PathVariable("userId") User userId) {
        Task originalTask = taskRepo.findById(taskId);
        originalTask.setUserId(userId);
        taskRepo.save(originalTask);
        sendGridService.sendEmail(userId.getEmail(),"Task Assigned","New Task is Assigned to you");
        return ResponseEntity.ok().build();
    }
}
