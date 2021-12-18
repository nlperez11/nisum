package com.nisum.tech.application.service;


import com.nisum.tech.application.adapter.JwtAdapter;
import com.nisum.tech.application.repository.UserRepository;
import com.nisum.tech.application.service.impl.UserServiceImpl;
import com.nisum.tech.config.AppConfig;
import com.nisum.tech.config.exception.EmailDupedException;
import com.nisum.tech.config.exception.PasswordFormatException;
import com.nisum.tech.faker.UserFaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestPropertySource("/application.properties")
@EnableConfigurationProperties(AppConfig.class)
@DisplayName("Tests for UserService")
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtAdapter jwtAdapter;

    @Autowired
    private AppConfig config;

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, jwtAdapter, config);
    }

    @Test
    @DisplayName("Validate nulls")
    void validateNulls() {
        assertNotNull(userRepository);
        assertNotNull(jwtAdapter);
        assertNotNull(config);
        assertNotNull(userService);
    }

    @Test
    @DisplayName("When create user is called then return a valid object")
    void whenCreateUserIsCalledThenReturnValidObject() throws Exception {

        var user = UserFaker.userFaker();
        when(userRepository.save(any())).thenReturn(user);

        var result = userService.createUser(user);

        assertEquals(user, result);
    }

    @Test
    @DisplayName("When create user is called then return an error because duped email")
    void whenCreateUserIsCalledThenReturnErrorBecauseDupedEmail() throws Exception {

        var user = UserFaker.userFaker();
        when(userRepository.save(any())).thenThrow(new DataIntegrityViolationException("duped fk"));

        assertThrows(EmailDupedException.class, () -> userService.createUser(user));

    }

    @Test
    @DisplayName("When create user is called with bad password format then return an error")
    void whenCreateUserIsCalledWithBadPasswordThenReturnError() {

        var user = UserFaker.userFaker();
        user.setPassword("badpasswordformat");

        when(userRepository.save(any())).thenReturn(user);

        assertThrows(PasswordFormatException.class, () -> userService.createUser(user));
    }
}
