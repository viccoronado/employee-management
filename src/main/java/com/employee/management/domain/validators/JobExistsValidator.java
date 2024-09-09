package com.employee.management.domain.validators;

import com.employee.management.domain.exceptions.JobNotFoundException;
import com.employee.management.domain.repositories.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("jobExistsValidator")
@RequiredArgsConstructor
public class JobExistsValidator implements Validator<Long> {

    private final JobRepository jobRepository;

    @Override
    public void validate(Long jobId) {
        if (!jobRepository.existsById(jobId)) {
            throw new JobNotFoundException("Job not found.");
        }
    }
}
