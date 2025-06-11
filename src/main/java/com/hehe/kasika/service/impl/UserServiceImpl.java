package com.hehe.kasika.service.impl;

import com.hehe.kasika.model.Users;
import com.hehe.kasika.model.enums.ROLE_USER;
import com.hehe.kasika.repository.UserRepository;
import com.hehe.kasika.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users createUser(String username, String password, String phoneNumber) {

        Users user = Users.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .build();

        return userRepository.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)
        );
    }

    @Override
    public Users getFromContext() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + userDetails.getUsername())
        );
    }

    @Override
    public Users addRoleUser(ROLE_USER role,  Users user) {
        if(user.getRoles().contains(role)) {
            return userRepository.save(user);
        }else {
            user.getRoles().add(role);
            return userRepository.save(user);
        }
    }
}
