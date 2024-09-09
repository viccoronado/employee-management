package com.example.application.dto;

public class TimeEntryResponseDto {
    private final Long id;
    private final boolean success;

    public TimeEntryResponseDto(Long id, boolean success) {
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