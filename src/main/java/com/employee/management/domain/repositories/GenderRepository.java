package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    boolean existsById(Long id);
}
