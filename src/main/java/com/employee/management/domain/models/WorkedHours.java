package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class WorkedHours {
    @NonNull
    private final Long employeeId;
    @NonNull
    private final LocalDate workedDate;
    private final int workedHours;
}
