package com.dengooo.springcloud.service;

import com.dengooo.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
