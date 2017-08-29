package com.solwin.test.service;

import java.util.List;

import com.solwin.test.entity.Subscription;

public interface ISubscriptionService {
    List<Subscription> getAllSubscriptions();
    Subscription getSubscriptionById(int subscriptionId);
    boolean addSubscription(Subscription subscription);
    void updateSubscription(Subscription subscription);
    void deleteSubscription(int subscriptionId);
}
