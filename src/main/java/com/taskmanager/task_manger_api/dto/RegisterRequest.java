package com.taskmanager.task_manger_api.dto;

import lombok.Data;

// This is the "form" a user fills in to register
@Data
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
}
