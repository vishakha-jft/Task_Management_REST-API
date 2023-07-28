package com.example.taskmanagement.dtos;

import jakarta.persistence.Column;

public class UserDto {
    private String name;
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private String email;
}
