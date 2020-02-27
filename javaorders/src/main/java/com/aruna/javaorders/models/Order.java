package com.aruna.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column(nullable = false)
    private double ordamount;
    private double advanceamount;
    private String orderdescription;

    @ManyToOne
    @JoinColumn(name="custcode",
            nullable = false)
    @JsonIgnoreProperties("orders")
    private Customer orderCustomer;

    @OneToMany(mappedBy = "ordernumber",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties("ordernumber")
    private List<OrderPayments> orderpayments = new ArrayList<>();

    public Order(double ordamount,double advanceamount, Customer orderCustomer,String orderdescription) {
        this.advanceamount = advanceamount;
        this.ordamount = ordamount;
        this.orderdescription = orderdescription;
        this.orderCustomer = orderCustomer;
    }

    public Order() {
    }



    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(Customer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public List<OrderPayments> getOrderpayments() {
        return orderpayments;
    }

    public void setOrderpayments(List<OrderPayments> orderpayments) {
        this.orderpayments = orderpayments;
    }
}
