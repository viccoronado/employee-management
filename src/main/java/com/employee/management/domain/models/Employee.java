package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class Employee {
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private LocalDate birthdate;

    @NonNull
    private Long genderId;

    @NonNull
    private Long jobId;
}
