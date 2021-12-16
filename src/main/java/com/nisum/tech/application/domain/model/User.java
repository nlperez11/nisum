package com.nisum.tech.application.domain.model;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Value
@Builder
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column
    String email;

    @Column
    String password;

    @OneToMany(mappedBy = "user")
    List<Phone> phones;

}
