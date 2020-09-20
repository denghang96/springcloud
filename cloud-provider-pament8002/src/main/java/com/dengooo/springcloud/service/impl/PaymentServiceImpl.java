package com.dengooo.springcloud.service.impl;

import com.dengooo.springcloud.dao.PaymentDao;
import com.dengooo.springcloud.entities.Payment;
import com.dengooo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
