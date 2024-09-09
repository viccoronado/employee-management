package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class JobIdRequestDto {
    @NonNull
    private Long jobId;
}
