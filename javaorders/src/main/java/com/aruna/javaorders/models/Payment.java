package com.aruna.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    @Column
    private String type;

    @OneToMany(mappedBy = "paymentsid",
                cascade = CascadeType.ALL)
    @JsonIgnoreProperties("paymentsid")
    private List<OrderPayments> orderpayments = new ArrayList<>();

    public Payment(String type) {
        this.type = type;
    }

    public Payment() {
    }


    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public List<OrderPayments> getOrderpayments() {
        return orderpayments;
    }

    public void setOrderpayments(List<OrderPayments> orderpayments) {
        this.orderpayments = orderpayments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}