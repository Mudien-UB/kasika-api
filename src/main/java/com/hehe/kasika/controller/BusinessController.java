package com.hehe.kasika.controller;

import com.hehe.kasika.dto.request.BusinessRequest;
import com.hehe.kasika.dto.response.BusinessResponse;
import com.hehe.kasika.service.BusinesService;
import com.hehe.kasika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/business")
public class BusinessController {

    private final BusinesService businessService;
    private final UserService userService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/register")
    public ResponseEntity<?> registerBusiness(@Validated @RequestBody BusinessRequest businessRequest) {

        var user = userService.getFromContext();
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        var response = businessService.addBusiness(
                businessRequest.getName(),
                businessRequest.getPhoneNumber(),
                user
        );
        if(response == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(BusinessResponse.of(response));
    }

}
