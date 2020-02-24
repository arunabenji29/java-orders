package com.aruna.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "orderspayments",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ordnum","paymentid"})})
public class OrderPayments implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ordnum")
    @JsonIgnoreProperties("orders")
    private Order ordernumber;

    @Id
    @ManyToOne
    @JoinColumn(name = "paymentid")
    @JsonIgnoreProperties("payments")
    private Payment paymentsid;

    public OrderPayments(Order ordernumber, Payment paymentsid) {
        this.ordernumber = ordernumber;
        this.paymentsid = paymentsid;
    }

    public OrderPayments() {
    }

    public Order getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Order ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Payment getPaymentsid() {
        return paymentsid;
    }

    public void setPaymentsid(Payment paymentsid) {
        this.paymentsid = paymentsid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderPayments)) return false;
        OrderPayments that = (OrderPayments) o;
        return Objects.equals(getOrdernumber(), that.getOrdernumber()) &&
                Objects.equals(getPaymentsid(), that.getPaymentsid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrdernumber(), getPaymentsid());
    }

    @Override
    public String toString() {
        return "OrderPayments{" +
                "ordernumber=" + ordernumber +
                ", paymentsid=" + paymentsid +
                '}';
    }
}
