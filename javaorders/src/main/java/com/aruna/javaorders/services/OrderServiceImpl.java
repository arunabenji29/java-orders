package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Order;
import com.aruna.javaorders.models.OrderPayments;
import com.aruna.javaorders.models.Payment;
import com.aruna.javaorders.repositories.OrderRepository;
import com.aruna.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderrepos;

    @Autowired
    private PaymentRepository paymentrepos;

    @Override
    public Order findById(long id) {
        return orderrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Order id " + id + " not found"));
    }

    @Transactional
    @Override
    public Order save(Order order) {
        Order neworder = new Order();
        neworder.setAdvanceamount(order.getAdvanceamount());
        neworder.setOrdamount(order.getOrdamount());
        neworder.setOrderCustomer(order.getOrderCustomer());
        neworder.setOrderdescription(order.getOrderdescription());

        ArrayList<OrderPayments> newPayments = new ArrayList<>();

        for(OrderPayments op : order.getOrderpayments())
        {
            long id = op.getPaymentsid()
                    .getPaymentid();

            Payment payment = paymentrepos.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("payment id " + id + " not found"));

            newPayments.add(new OrderPayments(neworder, payment));
        }
        return orderrepos.save(neworder);
    }

    @Transactional
    @Override
    public void addOrderPayments(long orderid, long paymentid) {

        orderrepos.findById(orderid)
                .orElseThrow(() -> new EntityNotFoundException("order id "+ orderid+ " not found"));

        paymentrepos.findById(paymentid)
                .orElseThrow(() -> new EntityNotFoundException("payment id "+ paymentid + " not found"));

        if(paymentrepos.checkOrderPaymentsCombo(orderid,paymentid)
                        .getCount() <= 0){
            paymentrepos.insertOrderPayments(orderid, paymentid);
        }
        else{
            throw new EntityNotFoundException("Order and Payment Combination Already Exists");
        }


    }
}
