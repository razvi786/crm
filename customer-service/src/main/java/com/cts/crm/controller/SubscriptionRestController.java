package com.cts.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("customers/{customerId}/subscriptions/active")
	public ResponseEntity<List<Subscription>> viewActiveSubscriptions(@PathVariable int customerId) {
		return dataServiceProxy.viewActiveSubscriptions(customerId);
	}
	
	@PostMapping("subscriptions")
	public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
		return dataServiceProxy.createSubscription(subscription);
	}
	
}
