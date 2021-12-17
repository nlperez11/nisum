package com.nisum.tech.application.service;

import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    List<Phone> phones();
}
