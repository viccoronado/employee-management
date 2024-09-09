package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class WorkedHours {
    private UUID id;
    private Long employeeId;
    private int workedHours;
    private LocalDate workedDate;
}
