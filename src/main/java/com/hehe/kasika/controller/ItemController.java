package com.hehe.kasika.controller;

import com.hehe.kasika.dto.request.ItemRequest;
import com.hehe.kasika.dto.response.ItemResponse;
import com.hehe.kasika.dto.validation.OnCreate;
import com.hehe.kasika.model.Business;
import com.hehe.kasika.model.Users;
import com.hehe.kasika.service.ItemService;
import com.hehe.kasika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertItem( @Validated(OnCreate.class) @RequestBody ItemRequest itemRequest) {

        Users user = userService.getFromContext();

        var response =  itemService.addItem(
                user.getBusiness(),
                itemRequest.getName(),
                itemRequest.getPrice(),
                itemRequest.getUnit()
        );
        if(response == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ItemResponse.of(response));
    }

    @GetMapping
    public ResponseEntity<?> getItems() {

        Business business = userService.getFromContext().getBusiness();

        if(business == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        var response =  itemService.getItems(business);
        if(response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response.stream().map(ItemResponse::of).toList());
    }

}
