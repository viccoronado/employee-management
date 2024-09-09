package com.employee.management.domain.models;

import java.time.LocalDate;
import java.util.Objects;

public class WorkedHours {

    private Long id;
    private Long employeeId;
    private int workedHours;
    private LocalDate workedDate;

    private WorkedHours(WorkedHoursBuilder builder) {
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
        if (workedHours <= 0 || workedHours > 20) {
            throw new IllegalArgumentException("Worked hours must be between 1 and 20.");
        }
        if (Objects.isNull(workedDate) || workedDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Worked date cannot be in the future.");
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public static class WorkedHoursBuilder {
        private Long id;
        private Long employeeId;
        private int workedHours;
        private LocalDate workedDate;

        public WorkedHoursBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public WorkedHoursBuilder withEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public WorkedHoursBuilder withWorkedHours(int workedHours) {
            this.workedHours = workedHours;
            return this;
        }

        public WorkedHoursBuilder withWorkedDate(LocalDate workedDate) {
            this.workedDate = workedDate;
            return this;
        }

        public WorkedHours build() {
            return new WorkedHours(this);
        }
    }
}