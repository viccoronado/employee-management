package com.employee.management.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Double amount;
    private LocalDate date;

    private Payment(Builder builder) {
        this.id = builder.id;
        this.employeeId = builder.employeeId;
        this.amount = builder.amount;
        this.date = builder.date;

        validate();
    }

    public Payment() {

    }

    private void validate() {
        if (Objects.isNull(employeeId)) {
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }
        if (Objects.isNull(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (Objects.isNull(date)) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static class Builder {
        private Long id;
        private Long employeeId;
        private Double amount;
        private LocalDate date;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder withAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}