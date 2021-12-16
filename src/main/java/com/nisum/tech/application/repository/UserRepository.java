package com.nisum.tech.application.repository;

import com.nisum.tech.application.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
