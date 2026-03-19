package com.taskmanager.task_manger_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                          // Lombok: auto-generates ALL getters, setters, toString
@NoArgsConstructor             // Lombok: generates User() empty constructor
@AllArgsConstructor            // Lombok: generates User(id, username, ...) constructor
@Entity                        // Tells Spring: "this class = a database table"
@Table(name = "users")         // The table will be named "users" in MySQL
public class User {

    @Id // This field is the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment: 1, 2, 3...
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;        // Cannot be empty, must be unique

    @Column(nullable = false, unique = true, length = 100)
    private String email;       // Cannot be empty, must be unique

    @Column(nullable = false)
    private String password;        // Cannot be empty (we'll hash this later)

    @Column(nullable = false)
    private String role;            // "ROLE_USER" or "ROLE_ADMIN"

}
