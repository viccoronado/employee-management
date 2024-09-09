package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Job {
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Double salary;
}
