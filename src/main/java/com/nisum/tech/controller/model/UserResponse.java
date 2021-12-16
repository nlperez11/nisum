package com.nisum.tech.controller.model;

import com.nisum.tech.application.domain.model.User;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {

    String name;
    String email;

    public static UserResponse of(User user) {
        return UserResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
