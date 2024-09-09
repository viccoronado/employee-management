package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Employee {
    private final Long id;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final LocalDate birthDate;
    @NonNull
    private final Long genderId;
    @NonNull
    private final Long jobId;
}
