package com.nisum.tech.application.service;

import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.config.exception.EmailDupedException;
import com.nisum.tech.config.exception.PasswordFormatException;

public interface UserService {

    User createUser(User user) throws EmailDupedException, PasswordFormatException;

}
