package com.employee.management.domain.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PaymentRepository {

    double calculateTotalAmount(Long employeeId, LocalDate startDate, LocalDate endDate);
}
