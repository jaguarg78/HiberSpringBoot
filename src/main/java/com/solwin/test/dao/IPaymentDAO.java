package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.Payment;
import com.solwin.test.structures.DateRange;

public interface IPaymentDAO {
    List<Payment> getAllPayments();
    Payment getPaymentById(BigInteger paymentId);
    List<Payment> getPaymentsByUser(BigInteger userId);
    List<Payment> getPaymentsBySubscription(Integer subscriptionId);
    List<Payment> getPaymentsByDateRange(DateRange dateRange);
    void addPayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(BigInteger paymentId);
    boolean paymentExists(Payment payment);
}
