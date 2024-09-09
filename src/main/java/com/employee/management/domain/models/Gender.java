package com.employee.management.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Gender {
    @NonNull
    private final Long id;
    @NonNull
    private final String name;
}
