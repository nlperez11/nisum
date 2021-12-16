package com.nisum.tech.application.domain.model;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Value
@Builder
@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String number;

    @Column
    String cityCode;

    @Column
    String countryCode;

    @ManyToMany(mappedBy = "phones")
    User user;

}
