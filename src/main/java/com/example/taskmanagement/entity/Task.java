package com.example.taskmanagement.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name= "User_id")
    private User userId;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        TO_DO,
        IN_PROGRESS,
        DONE
    }
    private LocalDate dueDate;
}
