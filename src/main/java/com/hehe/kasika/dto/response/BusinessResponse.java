package com.hehe.kasika.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hehe.kasika.model.Business;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BusinessResponse(
        String name,
        String phoneNumber,

        @JsonFormat(pattern = "dd-MM-yy")
        LocalDateTime createdAt
) {

    public static BusinessResponse of(@NotNull Business business) {
        return new BusinessResponse(
                business.getName(),
                business.getPhoneNumber(),
                business.getCreateAt()
        );
    }
}
