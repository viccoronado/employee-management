package com.employee.management.domain.models;

import java.time.LocalDate;

public class Employee {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Long genderId;
    private final Long jobId;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.genderId = builder.genderId;
        this.jobId = builder.jobId;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public Long getGenderId() { return genderId; }
    public Long getJobId() { return jobId; }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private Long genderId;
        private Long jobId;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.firstName = name;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withGenderId(Long genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder withJobId(Long jobId) {
            this.jobId = jobId;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}