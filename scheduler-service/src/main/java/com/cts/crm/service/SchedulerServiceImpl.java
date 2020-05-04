package com.cts.crm.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.model.Subscription;
import com.cts.crm.service.proxy.DataServiceProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchedulerServiceImpl implements SchedulerService {
	
	@Autowired
	DataServiceProxy dataServiceProxy;

	@Override
	public void inactiveSubscription() {
		List<Subscription> subscriptions=dataServiceProxy.getAllSubscriptions().getBody();
		List<Subscription> todaySubscriptions = subscriptions.parallelStream().filter((sub)->sub.getExpiryDate()
				.toLocalDate().equals(LocalDate.now()))
				.collect(Collectors.toList());
		dataServiceProxy.batchInactiveSubscriptions(todaySubscriptions);
		todaySubscriptions.forEach((sub)->log.info("Subscription: {} is now inactive", sub.getId()));
	}

}
