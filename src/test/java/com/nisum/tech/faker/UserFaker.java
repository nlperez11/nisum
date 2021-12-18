package com.nisum.tech.faker;

import com.nisum.tech.application.domain.model.Phone;
import com.nisum.tech.application.domain.model.User;
import com.nisum.tech.controller.model.UserRequest;

import java.util.Collections;

public class UserFaker {

    public static User userFaker() {
        return new User(
                "123",
                "nestor",
                "asd@gmail.com",
                "Nlpe*61193",
                Collections.singletonList(phoneFaker())
        );
    }

    public static Phone phoneFaker() {
        return new Phone("02020202", "031", "+57");
    }

    public static UserRequest requestFaker() {
        var request = new UserRequest();
        request.setName("nestor");
        request.setEmail("nestorvzla11@gmail.com");
        request.setPassword("Nlpe*61193");
        request.setPhones(Collections.singletonList(
                phoneRequestFaker()
        ));
        return request;
    }

    private static UserRequest.PhoneRequest phoneRequestFaker() {
        var phone = new UserRequest.PhoneRequest();
        phone.setNumber("3007419822");
        phone.setCityCode("031");
        phone.setCountryCode("+57");
        return phone;
    }

}
