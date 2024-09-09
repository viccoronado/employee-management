package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT COALESCE(SUM(p.amount), 0) FROM Payment p WHERE p.employeeId = :employeeId AND p.date BETWEEN :startDate AND :endDate")
    double calculateTotalAmount(@Param("employeeId") Long employeeId, 
                                @Param("startDate") LocalDate startDate, 
                                @Param("endDate") LocalDate endDate);
}
