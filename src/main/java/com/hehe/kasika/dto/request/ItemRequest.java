package com.hehe.kasika.dto.request;

import com.hehe.kasika.dto.validation.OnCreate;
import com.hehe.kasika.dto.validation.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class ItemRequest {

    @Length(min = 1, max = 100, groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "unit cannot blank" , groups = OnCreate.class)
    private String name;

    @NotBlank(message = "unit cannot blank", groups = OnCreate.class)
    private Double price;

    @NotBlank(message = "unit cannot blank", groups = OnCreate.class)
    private String unit;

}
