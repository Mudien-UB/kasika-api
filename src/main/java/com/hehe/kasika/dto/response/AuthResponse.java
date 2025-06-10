package com.hehe.kasika.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AuthResponse(
        String token,

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        LocalDateTime timeStamp
) {
    public static AuthResponse of(String token) {
        return new AuthResponse(token, LocalDateTime.now());
    }
}
