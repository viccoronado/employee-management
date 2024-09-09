package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Job;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository {
    Optional<Job> findById(Long id);
    boolean existsById(Long id);
}
