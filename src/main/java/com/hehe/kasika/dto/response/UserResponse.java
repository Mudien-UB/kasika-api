package com.hehe.kasika.dto.response;


import com.hehe.kasika.model.Users;

public record UserResponse(
        String id,
        String username,
        String phoneNumber,
        String role
) {

    public static UserResponse of(Users user) {
        return new UserResponse(
                user.getId().toString(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getRole().name()
        );
    }
}
