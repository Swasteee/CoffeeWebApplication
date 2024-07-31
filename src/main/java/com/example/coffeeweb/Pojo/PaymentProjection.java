package com.example.coffeeweb.Pojo;

public interface PaymentProjection {

    default Integer getId() {
        return null;
    }

    String getPaymentId();

    String getAmount();

    String getTransactionDate();

    String getPaymentMethod();

}
