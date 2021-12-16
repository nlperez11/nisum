package com.nisum.tech.application.service.impl;

import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        return Arrays.asList(
                User.builder().name("nestor").build(),
                User.builder().name("zaida").build(),
                User.builder().name("thomas").build(),
                User.builder().name("isbeth").build(),
                User.builder().name("hidalgo").build()
        );
    }
}
