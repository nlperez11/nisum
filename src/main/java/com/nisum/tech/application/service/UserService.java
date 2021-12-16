package com.nisum.tech.application.service;

import com.nisum.tech.application.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}
