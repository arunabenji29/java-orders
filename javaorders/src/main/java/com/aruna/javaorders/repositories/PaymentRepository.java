package com.aruna.javaorders.repositories;
import com.aruna.javaorders.models.Payment;
import com.aruna.javaorders.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    @Query(value = "SELECT COUNT(*) as count FROM orderpayments WHERE ordernumber =:ordernumber AND paymentsid =: paymentsid",
            nativeQuery = true)
    JustTheCount checkOrderPaymentsCombo(long ordernumber,
                                         long paymentsid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO orderpayments(ordernumber,paymentsid)",
                nativeQuery = true)
    void insertOrderPayments(long ordernumber,
                             long paymentsid);
}
