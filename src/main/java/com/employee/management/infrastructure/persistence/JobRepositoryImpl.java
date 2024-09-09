package com.employee.management.infrastructure.persistence;

import com.employee.management.domain.models.Job;
import com.employee.management.domain.repositories.JobRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class JobRepositoryImpl implements JobRepository {

    private final Map<Long, Job> jobDatabase = new HashMap<>();

    @Override
    public Optional<Job> findById(Long id) {
        return Optional.ofNullable(jobDatabase.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return jobDatabase.containsKey(id);
    }

    public void save(Job job) {
        jobDatabase.put(job.getId(), job);
    }
}
