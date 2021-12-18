package com.nisum.tech.application.adapter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nisum.tech.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtAdapter {

    @Autowired
    private AppConfig config;

    public String generateToken(String uuid) {
        Algorithm algorithm = Algorithm.HMAC256(config.getJwtSecret());
        return JWT
                .create()
                .withIssuer(uuid)
                .sign(algorithm);
    }
}
