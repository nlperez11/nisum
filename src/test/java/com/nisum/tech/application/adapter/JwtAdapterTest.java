package com.nisum.tech.application.adapter;

import com.nisum.tech.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@TestPropertySource("/application.properties")
@EnableConfigurationProperties(AppConfig.class)
@Import(value = JwtAdapter.class)
@DisplayName("Tests for JwtAdapter")
public class JwtAdapterTest {

    @Autowired
    private AppConfig config;

    @Autowired
    private JwtAdapter jwtAdapter;

    @Test
    @DisplayName("Validate nulls")
    void validateNulls() {
        assertNotNull(config);
        assertNotNull(jwtAdapter);
    }

    @Test
    @DisplayName("When generate token is called then return a new token")
    void whenGenerateTokenIsCalledThenReturnNewToken() {

        var result = jwtAdapter.generateToken("uuid");
        assertInstanceOf(String.class, result);
    }


}
