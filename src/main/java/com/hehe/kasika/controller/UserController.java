package com.hehe.kasika.controller;

import com.hehe.kasika.dto.response.UserResponse;
import com.hehe.kasika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> whoAmI(){
        return ResponseEntity.ok(UserResponse.of(userService.getFromContext()));

    }


}
