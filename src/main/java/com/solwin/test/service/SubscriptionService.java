package com.solwin.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwin.test.dao.ISubscriptionDAO;
import com.solwin.test.entity.Subscription;

@Service
public class SubscriptionService implements ISubscriptionService {
	@Autowired
	private ISubscriptionDAO subscriptionDAO;
	
	@Override
	public List<Subscription> getAllSubscriptions() {
		return subscriptionDAO.getAllSubscriptions();
	}

	@Override
	public Subscription getSubscriptionById(int subscriptionId) {
		return subscriptionDAO.getSubscriptionById(subscriptionId);
	}

	@Override
	public boolean addSubscription(Subscription subscription) {
		// TODO: Check for throw exceptions
		if (subscriptionDAO.subscriptionExists(subscription)) {
            return false;
        }
		
		subscriptionDAO.addSubscription(subscription);
        return true;
	}

	@Override
	public void updateSubscription(Subscription subscription) {
		subscriptionDAO.updateSubscription(subscription);
	}

	@Override
	public void deleteSubscription(int subscriptionId) {
		subscriptionDAO.deleteSubscription(subscriptionId);
	}

}
