package com.nisum.tech.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserRequest {

    @JsonProperty("nombre")
    @NotBlank
    private String name;

    @JsonProperty("correo")
    @NotBlank
    @Pattern(
            message = "Incorrect email format",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"
    )
    private String email;

    @JsonProperty("contraseña")
    @NotBlank
    private String password;

    @JsonProperty("telefonos")
    private List<PhoneRequest> phones;

    @Data
    public static class PhoneRequest {

        @JsonProperty("numero")
        private String number;

        @JsonProperty("codigo_ciudad")
        private String cityCode;

        @JsonProperty("codigo_pais")
        private String countryCode;

        public Phone toDomain() {
            return new Phone(
                    number,
                    cityCode,
                    countryCode
            );
        }

    }

    public User toDomain() {
        return new User(
                UUID.randomUUID().toString(),
                name,
                email,
                password,
                phones.stream().map(PhoneRequest::toDomain).collect(Collectors.toList())
        );
    }

}
