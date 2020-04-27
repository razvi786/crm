package com.cts.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.dao.SubscriptionDao;
import com.cts.crm.model.Subscription;

@Service
public class SubscriptionService {
	@Autowired 
	private SubscriptionDao sdao;

	public Subscription addSubscription(Subscription subscription) {
		
		return sdao.save(subscription);
	}

}
