package com.example.domain.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Job {
    private final Long id;
    private final String name;
    private final BigDecimal salary;

    private Job(JobBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.salary = builder.salary;

        validate();
    }

    private void validate() {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("Job name cannot be null or empty.");
        }
        if (Objects.isNull(salary) || salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero.");
        }
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getSalary() { return salary; }

    public static class JobBuilder {
        private Long id;
        private String name;
        private BigDecimal salary;

        public JobBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public JobBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public JobBuilder withSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}
