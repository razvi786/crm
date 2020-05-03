package com.cts.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.exception.SubscriptionNotFoundException;
import com.cts.crm.model.Subscription;
import com.cts.crm.service.SubscriptionService;

@RestController
public class SubscriptionRestController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@GetMapping("view-active-subscriptions/{customerId}")
	public ResponseEntity<List<Subscription>> viewActiveSubscriptions(@PathVariable int customerId){
		List<Subscription> subscriptions = subscriptionService.viewActiveSubscriptions(customerId);
		return new ResponseEntity<List<Subscription>>(subscriptions,HttpStatus.OK);
	}

	@GetMapping("inactive-subscription/{id}")
	public ResponseEntity<Object> inactiveSubscription(@PathVariable int id) {
		Subscription subscription = subscriptionService.getSubscriptionById(id);
		if(subscription==null)
			throw new SubscriptionNotFoundException("Subscription with id:"+id+" not found");
		subscriptionService.inactiveSubscription(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("inactive-subscription/batch")
	public ResponseEntity<Object> batchInactiveSubscriptions(@RequestBody List<Subscription> subscriptions) {
		subscriptionService.batchInactiveSubscription(subscriptions);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("get-all-subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptions(){
		List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
		return new ResponseEntity<List<Subscription>>(subscriptions,HttpStatus.OK);
	}
	
	@PostMapping("create-subscription")
	public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
		Subscription createdSubscription = subscriptionService.createSubscription(subscription);
		return new ResponseEntity<Subscription>(createdSubscription,HttpStatus.CREATED);
	}
	
	@GetMapping("get-today-subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptionsOfToday(){
		List<Subscription> subscriptions = subscriptionService.getAllSubscriptionsOfToday();
		return new ResponseEntity<List<Subscription>>(subscriptions, HttpStatus.OK);
	}
	
}
