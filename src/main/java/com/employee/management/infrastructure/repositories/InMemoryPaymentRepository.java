package com.employee.management.infrastructure.repositories;

import com.employee.management.domain.models.Payment;
import com.employee.management.domain.repositories.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryPaymentRepository implements PaymentRepository {

    private final Map<Long, Payment> paymentStore = new HashMap<>();
    private long currentId = 1L;

    @Override
    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            payment.setId(currentId++);
        }
        paymentStore.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return Optional.ofNullable(paymentStore.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return paymentStore.containsKey(id);
    }

    @Override
    public double calculateTotalAmount(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return 0;
    }
}
