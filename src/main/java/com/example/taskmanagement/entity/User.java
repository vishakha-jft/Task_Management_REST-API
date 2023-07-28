package com.example.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true,nullable = false)
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'USER'")
    private Roles role;

    private enum Roles {
        ADMIN,
        USER
    }


//    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH,CascadeType.REFRESH}, mappedBy = "userId")
//    private List<Task> Task;

}