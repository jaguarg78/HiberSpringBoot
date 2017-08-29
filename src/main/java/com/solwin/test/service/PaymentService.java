package com.solwin.test.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.IPaymentDAO;
import com.solwin.test.entity.Payment;
import com.solwin.test.structures.DateRange;

@Service
public class PaymentService implements IPaymentService {
	@Autowired
	private IPaymentDAO paymentDAO;
	
	@Override
	public List<Payment> getAllPayments() {
		return paymentDAO.getAllPayments();
	}

	@Override
	public Payment getPaymentById(BigInteger paymentId) {
		return paymentDAO.getPaymentById(paymentId);
	}

	@Override
	public List<Payment> getPaymentsByUser(BigInteger userId) {
		return paymentDAO.getPaymentsByUser(userId);
	}

	@Override
	public List<Payment> getPaymentsBySubscription(Integer subscriptionId) {
		return paymentDAO.getPaymentsBySubscription(subscriptionId);
	}

	@Override
	public List<Payment> getPaymentsByDateRange(DateRange dateRange) {
		return paymentDAO.getPaymentsByDateRange(dateRange);
	}
	
	@Override
	public boolean addPayment(Payment payment) {
		if (paymentDAO.paymentExists(payment)) {
            return false;
        }
		
		paymentDAO.addPayment(payment);
        return true;
	}

	@Override
	public void updatePayment(Payment payment) {
		paymentDAO.updatePayment(payment);
	}

	@Override
	public void deletePayment(BigInteger paymentId) {
		paymentDAO.deletePayment(paymentId);
	}

	
}
