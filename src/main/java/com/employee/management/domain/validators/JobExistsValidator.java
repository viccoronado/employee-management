package com.employee.management.domain.validators;

import com.employee.management.domain.exceptions.JobNotFoundException;
import com.employee.management.domain.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobExistsValidator {

    private final JobRepository jobRepository;

    public void validate(Long jobId) {
        if (!jobRepository.existsById(jobId)) {
            throw new JobNotFoundException("Job not found.");
        }
    }
}

