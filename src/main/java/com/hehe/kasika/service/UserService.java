package com.hehe.kasika.service;

import com.hehe.kasika.model.Users;
import com.hehe.kasika.model.enums.ROLE_USER;
import jakarta.validation.constraints.NotNull;

public interface UserService {

    Users createUser(@NotNull String username, @NotNull String password, @NotNull String phoneNumber, @NotNull ROLE_USER role);
    Users findByUsername(@NotNull String username);
    Users getFromContext();

}
