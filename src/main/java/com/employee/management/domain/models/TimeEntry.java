package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class TimeEntry {
    private final Long id;
    @NonNull
    private final Long employeeId;
    @NonNull
    private final LocalDate workedDate;
    @NonNull
    private final Double workedHours;
}