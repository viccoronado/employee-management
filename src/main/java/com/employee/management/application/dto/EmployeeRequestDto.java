package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Long genderId;
    private Long jobId;
}
