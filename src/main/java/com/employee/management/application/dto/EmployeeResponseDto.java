package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeResponseDto {
    private final Long id;
    private final boolean success;
}
