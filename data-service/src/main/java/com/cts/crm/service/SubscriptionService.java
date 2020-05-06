package com.cts.crm.service;

import java.util.List;

import com.cts.crm.model.Subscription;

public interface SubscriptionService {
	
	public Subscription getSubscriptionById(int id);
	
	public List<Subscription> getAllSubscriptions();
	
	public List<Subscription> viewActiveSubscriptions(int customerId);
	
	public void inactiveSubscription(int id);	
	
	public Subscription createSubscription(Subscription subscription);
	
	public List<Subscription> getAllSubscriptionsOfToday();
	
	public void batchInactiveSubscription(List<Subscription> subscriptions);

}
