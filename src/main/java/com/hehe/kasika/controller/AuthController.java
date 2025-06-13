package com.hehe.kasika.controller;

import com.hehe.kasika.dto.request.AuthRequest;
import com.hehe.kasika.dto.request.UserRequest;
import com.hehe.kasika.dto.response.AuthResponse;
import com.hehe.kasika.dto.response.UserResponse;
import com.hehe.kasika.service.AuthService;
import com.hehe.kasika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        String token = authService.login(authRequest.getUsername(), authRequest.getPassword());

        if(token == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(AuthResponse.of(token));

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {

        var response = userService.createUser(
                userRequest.getUsername(),
                userRequest.getPassword(),
                userRequest.getPhoneNumber()
        );

        if(response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(UserResponse.of(response));

    }

    @GetMapping("/username-check")
    public ResponseEntity<?> usernameCheck(@RequestParam String username) {
        Map<String, Object> response = new HashMap<>();
        boolean taken = userService.isUsernameAlreadyInUse(username);

        response.put("available", !taken);
        response.put("message", taken ? "Username is already taken" : "Username is available");

        return ResponseEntity.ok(response);
    }


    @GetMapping("/test")
    public ResponseEntity<?> test() {
        String test = "test";
        return ResponseEntity.ok("test");
    }
}
