package com.dengooo.springcloud.service;

public interface PaymentService {
    public String PaymentInfo(Integer id);

    public String timeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
