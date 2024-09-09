package com.employee.management.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class EmployeePaymentRequestDto {
    @NonNull
    private Long employeeId;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate endDate;
}
