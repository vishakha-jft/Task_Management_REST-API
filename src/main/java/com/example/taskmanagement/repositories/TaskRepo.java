package com.example.taskmanagement.repositories;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findAll();

    List<Task> findByUserId(User userId);

    Task findById(int taskId);

    void deleteById(int taskId);
}
