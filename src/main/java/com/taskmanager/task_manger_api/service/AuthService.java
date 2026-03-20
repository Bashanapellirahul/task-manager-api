package com.taskmanager.task_manger_api.service;

import com.taskmanager.task_manger_api.dto.AuthResponse;
import com.taskmanager.task_manger_api.dto.LoginRequest;
import com.taskmanager.task_manger_api.dto.RegisterRequest;
import com.taskmanager.task_manger_api.model.User;
import com.taskmanager.task_manger_api.repository.UserRepository;
import com.taskmanager.task_manger_api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username is already taken!");
        }

        if(userRepository.existsByEmail(request.getEmail()))
        {
            throw new RuntimeException("Email is already registered!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return new AuthResponse(null, "User registered successfully!");
    }

    public AuthResponse login(LoginRequest loginRequest){
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password!");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token, "Login Successful!");
    }
}
