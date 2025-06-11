package com.hehe.kasika.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class BusinessRequest {

    @NotBlank(message = "name cannot be blank")
    @Length(min = 5, max = 100, message = "min char 5 and max 100")
    private String name;

    @Length(min = 12, max = 13, message = "invalid phone number")
    private String phoneNumber;

}
