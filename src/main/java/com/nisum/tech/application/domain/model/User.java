package com.nisum.tech.application.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;

    @Column
    private String name;

    @Column(unique = false)
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Phone> phones;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column
    private String accessToken;

    @Column
    boolean active;

    public User(String id, String name, String email, String password, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

}
