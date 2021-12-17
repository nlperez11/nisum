package com.nisum.tech.application.repository;

import com.nisum.tech.application.domain.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
