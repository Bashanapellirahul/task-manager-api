package com.taskmanager.task_manger_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This is what WE send BACK after a successful login — the token
@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String token;
}
