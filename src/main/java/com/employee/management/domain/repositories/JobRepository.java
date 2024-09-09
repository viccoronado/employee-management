package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    boolean existsById(Long id);
}