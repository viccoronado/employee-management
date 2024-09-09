package com.employee.management.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private JobDto jobDto;
    private GenderDto genderDto;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JobDto {
        private Long id;
        private String title;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GenderDto {
        private Long id;
        private String type;
    }
}
