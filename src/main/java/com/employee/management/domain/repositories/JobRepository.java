package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Job;
import java.util.Optional;

public interface JobRepository {
    Optional<Job> findById(Long id);
    boolean existsById(Long id);
}
