package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Payment;
import com.aruna.javaorders.repositories.OrderRepository;
import com.aruna.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private OrderRepository orderrepos;

    @Autowired
    private PaymentRepository paymentrepos;

    @Override
    public Payment save(Payment payment) {
        Payment newPayment = new Payment();
        newPayment.setType(payment.getType());

        if(payment.getOrderpayments()
        .size() > 0){
            throw new EntityNotFoundException("Order payments are not updated through Payments.");
        }
        return paymentrepos.save(payment);
    }
}
