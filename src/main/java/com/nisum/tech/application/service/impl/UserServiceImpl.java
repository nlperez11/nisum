package com.nisum.tech.application.service.impl;

import com.nisum.tech.application.dao.UserDAO;
import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) {
        var u = userDAO.save(user);
        System.out.println("u = " + u);
        return u;
    }
}
