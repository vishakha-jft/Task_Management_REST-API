package com.example.taskmanagement.controller;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskRepo taskRepo;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody Task task){
        System.out.println("Received data: " + task);
        taskRepo.save(task);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Task> allTasks(){
        System.out.println("Received alll tasksssssssss");
        List<Task> taskList = taskRepo.findAll();
        System.out.println("Received data: " + taskList );
        return taskList;
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable("taskId") int taskId){
        Task task = taskRepo.findById(taskId);
        return task;
    }

    @PutMapping(value = "/{taskId}")
    public ResponseEntity<Void> updateTask(@RequestBody Task task){
        System.out.println("Received data: " + task);
        Task originalTask = taskRepo.findById(task.getId());
        originalTask.setStatus(task.getStatus());
        originalTask.setDueDate(task.getDueDate());
        originalTask.setDescription(task.getDescription());
        originalTask.setName(task.getName());
        taskRepo.save(originalTask);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") int taskId) {
        taskRepo.deleteById(taskId);
        return ResponseEntity.ok().build();
    }

}

