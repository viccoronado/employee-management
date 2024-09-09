package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class WorkedHours {
    private UUID id;
    private Long employeeId;
    private Integer workedHours;
    private LocalDate workedDate;
}
