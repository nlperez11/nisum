package com.nisum.tech.application.service.impl;

import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(User user) {
        return User.builder().name("nestor").build();
    }
}
