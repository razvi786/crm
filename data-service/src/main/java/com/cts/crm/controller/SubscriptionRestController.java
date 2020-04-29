package com.cts.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Subscription;
import com.cts.crm.service.SubscriptionService;

@RestController
public class SubscriptionRestController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@GetMapping("view-active-subscriptions/{customerId}")
	public List<Subscription> viewActiveSubscriptions(@PathVariable int customerId){
		return subscriptionService.viewActiveSubscriptions(customerId);
	}

	@GetMapping("inactive-subscription/{id}")
	public void inactiveSubscription(@PathVariable int id) {
		subscriptionService.inactiveSubscription(id);
	}
	
	@PostMapping("create-subscription")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return subscriptionService.createSubscription(subscription);
	}
	
}
