package com.example.application.dto;

import java.time.LocalDate;

public class TimeEntryRequestDto {
    private final Long employeeId;
    private final Double workedHours;
    private final LocalDate workedDate;

    public TimeEntryRequestDto(Long employeeId, Double workedHours, LocalDate workedDate) {
        this.employeeId = employeeId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
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
}
