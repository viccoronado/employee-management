package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Gender;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository {
    Optional<Gender> findById(Long id);
    boolean existsById(Long id);
}
