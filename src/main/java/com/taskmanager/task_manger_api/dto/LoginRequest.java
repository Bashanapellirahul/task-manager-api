package com.taskmanager.task_manger_api.dto;

import lombok.Data;

// This is the "form" a user fills in to login
@Data
public class LoginRequest {
    private String username;
    private String password;
}
