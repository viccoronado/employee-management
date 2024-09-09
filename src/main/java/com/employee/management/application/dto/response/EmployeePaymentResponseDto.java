package com.employee.management.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeePaymentResponseDto {
    private Integer payment;
    private Boolean success;
}
