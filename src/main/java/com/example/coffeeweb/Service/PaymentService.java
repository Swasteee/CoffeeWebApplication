package com.example.coffeeweb.Service;

import com.example.coffeeweb.Entity.Payment;
import com.example.coffeeweb.Pojo.PaymentPojo;

import java.util.List;

public interface PaymentService {

    Integer

    savePayment(PaymentPojo paymentPojo);

    List<Payment> findAll();

    Payment findById(Integer id);

    void deleteById(Integer id);


}
