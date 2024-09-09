package com.employee.management.domain.services;

import com.employee.management.domain.models.Payment;
import com.employee.management.domain.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public boolean paymentExists(Long id) {
        return paymentRepository.existsById(id);
    }
}
