package com.nisum.tech.application.dao;

import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
