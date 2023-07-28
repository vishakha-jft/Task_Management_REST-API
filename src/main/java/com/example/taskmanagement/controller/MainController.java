package com.example.taskmanagement.controller;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repositories.TaskRepo;
import com.example.taskmanagement.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TaskRepo taskRepo;
    @GetMapping("tasks/new")
    public String newTask(Model model){
        System.out.println("new taskkkkkkk " );
        Task t1 = new Task();
        model.addAttribute("task",t1);
        return "newTask";
    }
    @RequestMapping(value = "/")
    public String login(Model model) {
        System.out.println("indexxxxxxxxxxxxxxxxx" );
        User user = new User();
        model.addAttribute("user",user);
        return "index";
    }
    @GetMapping(value = "/home")
    public String Login( Model model) {
        List<Task> taskList = taskRepo.findAll();
        model.addAttribute("taskList",taskList);
        System.out.println("Received data: " + taskList );
        return "home";
    }

    @GetMapping(value = "/userTasks")
    public String userTasks(Model model) {
        List<User> userList = userRepo.findAll();
        model.addAttribute("userList",userList);
        System.out.println("Received data: " + userList );
        return "usersTask";
    }

}
