package com.hehe.kasika.service;

import jakarta.validation.constraints.NotNull;

public interface AuthService {

    String login(@NotNull String username, @NotNull String password);
}
