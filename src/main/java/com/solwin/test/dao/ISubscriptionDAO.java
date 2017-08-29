package com.solwin.test.dao;

import java.util.List;

import com.solwin.test.entity.Subscription;

public interface ISubscriptionDAO {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int subscriptionId);
    void addSubscription(Subscription subscription);
    void updateSubscription(Subscription subscription);
    void deleteSubscription(int subscriptionId);
    boolean subscriptionExists(Subscription subscription);
}
