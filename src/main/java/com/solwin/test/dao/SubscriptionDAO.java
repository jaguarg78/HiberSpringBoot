package com.solwin.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solwin.test.entity.Subscription;

@Transactional
@Repository
public class SubscriptionDAO implements ISubscriptionDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription> getAllSubscriptions() {
		String hql = "FROM Subscription AS sub ORDER BY sub.id";
		return (List<Subscription>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Subscription getSubscriptionById(int subscriptionId) {
		return entityManager.find(Subscription.class, subscriptionId);
	}

	@Override
	public void addSubscription(Subscription subscription) {
		entityManager.persist(subscription);
	}

	@Override
	public void updateSubscription(Subscription subscription) {
		Subscription subs = getSubscriptionById(subscription.getId());
		subs.setName(subs.getName());
		subs.setMonthlyFee(subs.getMonthlyFee());
		
		entityManager.flush();
	}

	@Override
	public void deleteSubscription(int subscriptionId) {
		entityManager.remove(getSubscriptionById(subscriptionId));
	}

	@Override
	public boolean subscriptionExists(Subscription subscription) {
		return entityManager
				.createQuery("FROM Subscription AS sub " +
						    "WHERE sub.name = ? " +
						      "AND sub.monthlyFee = ?")
					.setParameter(1, subscription.getName())
					.setParameter(2, subscription.getMonthlyFee())
						.getResultList().size() > 0;
	}
	
}
