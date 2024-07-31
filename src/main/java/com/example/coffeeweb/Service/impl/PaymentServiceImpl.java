package com.example.coffeeweb.Service.impl;

import com.example.coffeeweb.Entity.Payment;
import com.example.coffeeweb.Pojo.PaymentPojo;
import com.example.coffeeweb.Repository.PaymentRepository;
import com.example.coffeeweb.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Integer savePayment(PaymentPojo paymentPojo) {
        Payment payment = new Payment();
        payment.setPayment_id(paymentPojo.getPayment_id());
        payment.setPaymentMethod(paymentPojo.getPayment_method());
        payment.setAmount(paymentPojo.getAmount());
        paymentRepository.save(payment);
        return payment.getPayment_id();
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        paymentRepository.deleteById(id);

    }
}
