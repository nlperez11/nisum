package com.nisum.tech.application.service.impl;

import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.repository.PhoneRepository;
import com.nisum.tech.application.repository.UserRepository;
import com.nisum.tech.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Phone> phones() {
        return phoneRepository.findAll();
    }
}
