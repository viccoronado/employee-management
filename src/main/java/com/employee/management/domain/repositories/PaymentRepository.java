package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Payment;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PaymentRepository {

    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    boolean existsById(Long id);
    double calculateTotalAmount(Long employeeId, LocalDate startDate, LocalDate endDate);
}
