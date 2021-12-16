package com.nisum.tech.application.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class User {

    String name;
    String email;
    String password;
    List<Phone> phones;

}
