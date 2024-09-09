package com.employee.management.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class EmployeeRequestDto {
    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private Long genderId;

    @NonNull
    private Long jobId;

    @NonNull
    private LocalDate birthDate;
}
