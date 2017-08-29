package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import com.solwin.test.entity.Payment;
import com.solwin.test.structures.DateRange;

public interface IPaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(BigInteger paymentId);
    List<Payment> getPaymentsByUser(BigInteger userId);
    List<Payment> getPaymentsBySubscription(Integer subscriptionId);
    List<Payment> getPaymentsByDateRange(DateRange dateRange);
    boolean addPayment(Payment user);
    void updatePayment(Payment user);
    void deletePayment(BigInteger paymentId);
}
