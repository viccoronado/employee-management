package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private JobDto job;
    private GenderDto gender;

    @Getter
    @Builder
    public static class JobDto {
        private Long id;
        private String name;
        private Double salary;
    }

    @Getter
    @Builder
    public static class GenderDto {
        private Long id;
        private String name;
    }
}
