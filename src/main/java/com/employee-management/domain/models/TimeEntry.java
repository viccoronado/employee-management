package com.example.domain.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TimeEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Double workedHours;
    private LocalDate workedDate;

    // Default constructor for JPA
    protected TimeEntry() {
    }

    private TimeEntry(Builder builder) {
        this.id = builder.id;
        this.employeeId = builder.employeeId;
        this.workedHours = builder.workedHours;
        this.workedDate = builder.workedDate;

        validate();
    }

    private void validate() {
        if (Objects.isNull(employeeId)) {
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }
        if (Objects.isNull(workedHours) || workedHours <= 0) {
            throw new IllegalArgumentException("Worked hours must be greater than zero.");
        }
        if (Objects.isNull(workedDate)) {
            throw new IllegalArgumentException("Worked date cannot be null.");
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public static class Builder {
        private Long id;
        private Long employeeId;
        private Double workedHours;
        private LocalDate workedDate;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder withWorkedHours(Double workedHours) {
            this.workedHours = workedHours;
            return this;
        }

        public Builder withWorkedDate(LocalDate workedDate) {
            this.workedDate = workedDate;
            return this;
        }

        public TimeEntry build() {
            return new TimeEntry(this);
        }
    }
}