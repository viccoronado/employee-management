package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
@Builder
public class Job {
    private final Long id;
    @NonNull
    private final String name;
    @NonNull
    private final BigDecimal salary;
}
