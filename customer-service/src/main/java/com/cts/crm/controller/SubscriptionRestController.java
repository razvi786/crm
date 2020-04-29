package com.cts.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Subscription;
import com.cts.crm.service.proxy.DataServiceProxy;

@RestController
public class SubscriptionRestController {
	
	@Autowired
	DataServiceProxy dataServiceProxy;
	
	@GetMapping("view-active-subscriptions/{customerId}")
	public List<Subscription> viewActiveSubscriptions(@PathVariable int customerId){
		return dataServiceProxy.viewActiveSubscriptions(customerId);
	}
	
	@PostMapping("create-subscription")
	public Subscription createSubscription(@RequestBody Subscription subscription) {
		return dataServiceProxy.createSubscription(subscription);
	}
	
}
