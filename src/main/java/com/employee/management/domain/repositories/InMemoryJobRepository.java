package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Job;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryJobRepository implements JobRepository {
    private final Map<Long, Job> jobs = new HashMap<>();

    @Override
    public Optional<Job> findById(Long id) {
        return Optional.ofNullable(jobs.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return jobs.containsKey(id);
    }
}
