package com.nisum.tech.controller.model;

import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
@Builder
public class UserResponse {

    Long id;
    String name;
    String email;
    String password;
    List<PhoneResponse> phones;

    @Value
    @Builder
    public static class PhoneResponse {

        Long id;
        String number;
        String cityCode;
        String countryCode;

        public static PhoneResponse of(Phone phone) {
            return PhoneResponse
                    .builder()
                    .id(phone.getId())
                    .number(phone.getNumber())
                    .cityCode(phone.getCityCode())
                    .countryCode(phone.getCountryCode())
                    .build();
        }

    }

    public static UserResponse of(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phones(user.getPhones().stream().map(PhoneResponse::of).collect(Collectors.toList()))
                .build();
    }
}
