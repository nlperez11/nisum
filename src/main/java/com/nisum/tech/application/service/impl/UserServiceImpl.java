package com.nisum.tech.application.service.impl;

import com.nisum.tech.application.adapter.JwtAdapter;
import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.application.repository.UserRepository;
import com.nisum.tech.application.service.UserService;
import com.nisum.tech.config.AppConfig;
import com.nisum.tech.config.exception.EmailDupedException;
import com.nisum.tech.config.exception.PasswordFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtAdapter jwtAdapter;

    @Autowired
    private AppConfig config;

    @Override
    public User createUser(User user) throws EmailDupedException, PasswordFormatException {

        LocalDateTime now = LocalDateTime.now();
        user.setCreated(now);
        user.setModified(now);
        user.setActive(Boolean.TRUE);
        user.setAccessToken(jwtAdapter.generateToken(user.getId()));
        validatePassword(user.getPassword());

        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException  ex) {
            throw new EmailDupedException();
        }
    }

    private void validatePassword(String password) throws PasswordFormatException {
        Pattern pattern = Pattern.compile(config.getPatternPassword());
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new PasswordFormatException();
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
