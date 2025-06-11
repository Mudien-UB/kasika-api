package com.hehe.kasika.service.impl;

import com.hehe.kasika.model.Business;
import com.hehe.kasika.model.Users;
import com.hehe.kasika.model.enums.ROLE_USER;
import com.hehe.kasika.repository.BusinessRepository;
import com.hehe.kasika.repository.UserRepository;
import com.hehe.kasika.service.BusinesService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinesService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;

    @Override
    public List<Business> listBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business addBusiness(String name, String phoneNumber, Users user) {

        if(businessRepository.existsBusinessByName(name)){
            throw new EntityExistsException("Business name already exists");
        }

        Business business = Business.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
        businessRepository.saveAndFlush(business);

        user.setBusiness(business);
        user.getRoles().add(ROLE_USER.ADMIN);
        userRepository.save(user);

        return business;


    }
}
