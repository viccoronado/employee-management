package com.employee.management.application.dto;

public class EmployeeResponseDto {
    private final Long id;
    private final boolean success;

    public EmployeeResponseDto(Long id, boolean success) {
        this.id = id;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }
}
