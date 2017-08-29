package com.solwin.test.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.Payment;
import com.solwin.test.structures.DateRange;

@Transactional
@Repository
public class PaymentDAO implements IPaymentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getAllPayments() {
		// TODO: Fetch payments by pages
		String hql = "FROM Payment AS pay ORDER BY pay.id";
		return (List<Payment>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Payment getPaymentById(BigInteger paymentId) {
		return entityManager.find(Payment.class, paymentId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getPaymentsByUser(BigInteger userId) {
		// TODO: Fetch payments by pages
		String hql = "SELECT pay FROM Payment AS pay JOIN pay.user AS usr WHERE usr.id = ? ORDER BY pay.id";
		return (List<Payment>) entityManager
								.createQuery(hql)
									.setParameter(1, userId)
										.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getPaymentsBySubscription(Integer subscriptionId) {
		// TODO: Fetch payments by pages
		String hql = "SELECT pay FROM Payment AS pay JOIN pay.subscription AS sub WHERE sub.id = ? ORDER BY pay.id";
		return (List<Payment>) entityManager
								.createQuery(hql)
									.setParameter(1, subscriptionId)
										.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getPaymentsByDateRange(DateRange dateRange) {
		// TODO: Fetch payments by pages	
		String hql = "FROM Payment AS pay WHERE pay.";
		switch (dateRange.getType()) {
		case "STA":
			hql += "statementDate ";
			break;
		case "EXP":
			hql += "expirationDate ";
			break;
		case "PAY":
			hql += "paymentDate ";
			break;
		default:
			break;
		}
		hql += "BETWEEN ? AND ? ORDER BY pay.";
		switch (dateRange.getType()) {
		case "STA":
			hql += "statementDate";
			break;
		case "EXP":
			hql += "expirationDate";
			break;
		case "PAY":
			hql += "paymentDate";
			break;
		default:
			break;
		}
		
		return (List<Payment>) entityManager
								.createQuery(hql)
									.setParameter(1, dateRange.getFrom())
									.setParameter(2, dateRange.getTo())
										.getResultList();
	}
	
	@Override
	public void addPayment(Payment payment) {
		entityManager.persist(payment);
	}

	@Override
	public void updatePayment(Payment payment) {
		Payment pay = getPaymentById(payment.getId());
		pay.setUser(payment.getUser());
		pay.setSubscription(payment.getSubscription());
		pay.setDiscount(payment.getDiscount());
		pay.setDiscount(payment.getDiscount());
		pay.setStatementDate(payment.getStatementDate());
		pay.setExpirationDate(payment.getExpirationDate());
		pay.setPaymentDate(payment.getPaymentDate());
	
		entityManager.flush();
	}

	@Override
	public void deletePayment(BigInteger paymentId) {
		// TODO: Define delete process
		entityManager.remove(getPaymentById(paymentId));
	}
	
	@Override
	public boolean paymentExists(Payment payment) {
		return entityManager
						.createQuery("FROM Payment AS pay "+
		                            "WHERE pay.id = ? ")
							.setParameter(1, payment.getId())
								.getResultList().size() > 0;
	}
}
