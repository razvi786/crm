package com.cts.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.Subscription;
import com.cts.crm.service.SubscriptionService;

@RestController
public class SubscriptionController {
	@Autowired 
	private SubscriptionService sservice;
	@PostMapping("addSubscription")
	public Subscription addSubscription(@RequestBody Subscription subscription)
	{
		return sservice.addSubscription(subscription);
		
	}

}
