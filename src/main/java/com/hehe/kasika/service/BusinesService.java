package com.hehe.kasika.service;

import com.hehe.kasika.model.Business;
import com.hehe.kasika.model.Users;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface BusinesService {

    List<Business> listBusinesses();
    Business addBusiness(@NotNull String name,@NotNull String phoneNumber,@NotNull Users user);

}
