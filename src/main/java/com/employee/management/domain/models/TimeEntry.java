package com.employee.management.domain.models;

import java.time.Instant;
import java.time.LocalDate;

public class TimeEntry {
    private Long id;
    private Long employeeId;
    private LocalDate workedDate;
    private Double workedHours;

    public TimeEntry(Long employeeId, LocalDate workedDate, Double workedHours) {
        this.employeeId = employeeId;
        this.workedDate = workedDate;
        this.workedHours = workedHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDate workedDate) {
        this.workedDate = workedDate;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Double workedHours) {
        this.workedHours = workedHours;
    }

    public Instant getDate() {
        return null;
    }
}