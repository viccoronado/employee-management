package com.employee.management.application.dto;

import java.time.LocalDate;

public class EmployeeRequestDto {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Long genderId;
    private final Long jobId;

    private EmployeeRequestDto(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.genderId = builder.genderId;
        this.jobId = builder.jobId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getGenderId() {
        return genderId;
    }

    public Long getJobId() {
        return jobId;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Long genderId;
        private Long jobId;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder genderId(Long genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder jobId(Long jobId) {
            this.jobId = jobId;
            return this;
        }

        public EmployeeRequestDto build() {
            return new EmployeeRequestDto(this);
        }
    }
}