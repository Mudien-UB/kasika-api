package com.hehe.kasika.dto.response;


import com.hehe.kasika.model.Users;
import com.hehe.kasika.model.enums.ROLE_USER;

import java.util.List;

public record UserResponse(
        String id,
        String username,
        String phoneNumber,
        List<String> role
) {

    public static UserResponse of(Users user) {
        return new UserResponse(
                user.getId().toString(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getRoles().stream().map(ROLE_USER::name).toList()
        );
    }
}
