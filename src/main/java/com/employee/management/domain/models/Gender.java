package com.employee.management.domain.models;

import java.util.Objects;

public class Gender {
    private final Long id;
    private final String name;

    private Gender(GenderBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;

        validate();
    }

    private void validate() {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("Gender name cannot be null or empty.");
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long l) {
    }

    public static class GenderBuilder {
        private Long id;
        private String name;

        public GenderBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public GenderBuilder withName(String name) {
            return null;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}
