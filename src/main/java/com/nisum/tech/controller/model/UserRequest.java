package com.nisum.tech.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserRequest {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("contraseña")
    private String password;

    @JsonProperty("telefonos")
    private List<PhoneRequest> phones;

    @Data
    private static class PhoneRequest {

        @JsonProperty("numero")
        private String number;

        @JsonProperty("codigo_ciudad")
        private String cityCode;

        @JsonProperty("codigo_pais")
        private String countryCode;

        public Phone toDomain() {
            return new Phone(
                    null,
                    number,
                    cityCode,
                    countryCode,
                    null
            );
        }

    }

    public User toDomain() {
        return new User(
                null,
                name,
                email,
                password,
                phones.stream().map(PhoneRequest::toDomain).collect(Collectors.toList())
        );
    }

}
