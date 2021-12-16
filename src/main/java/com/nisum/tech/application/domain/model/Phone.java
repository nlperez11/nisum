package com.nisum.tech.application.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Phone {

    String number;
    String cityCode;
    String countryCode;

}
