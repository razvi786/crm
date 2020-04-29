package com.cts.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.model.Subscription;
import com.cts.crm.repo.SubscriptionRepo;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionRepo subscriptionRepo;
	
	@Override
	public List<Subscription> viewActiveSubscriptions(int customerId) {
		return subscriptionRepo.viewActiveSubscriptions(customerId);
	}

	@Override
	public void inactiveSubscription(int id) {
		subscriptionRepo.inactiveSubscription(id);
	}

	@Override
	public Subscription createSubscription(Subscription subscription) {
		return subscriptionRepo.save(subscription);
	}

}
