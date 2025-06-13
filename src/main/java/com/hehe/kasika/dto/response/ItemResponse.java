package com.hehe.kasika.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hehe.kasika.model.Item;

import java.time.LocalDateTime;

public record ItemResponse(
        String name,
        Double price,
        String unit,

        @JsonFormat(pattern = "dd-MM-yy")
        LocalDateTime lastUpdatedAt
) {

    public static ItemResponse of(Item item) {
        return new ItemResponse(
                item.getName(),
                item.getPrice(),
                item.getUnit(),
                item.getUpdateAt()
        );
    }
}
