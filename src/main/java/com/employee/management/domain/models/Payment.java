package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Payment {
    private final Long id;
    @NonNull
    private final Long employeeId;
    @NonNull
    private final Double amount;
    @NonNull
    private final LocalDate date;
}
