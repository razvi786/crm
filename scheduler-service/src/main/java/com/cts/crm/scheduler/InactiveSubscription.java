package com.cts.crm.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cts.crm.service.SchedulerService;
import com.cts.crm.service.proxy.DataServiceRestTemplate;

@Component
public class InactiveSubscription {
	
	@Autowired
	SchedulerService schedulerService;
	
	@Autowired
	DataServiceRestTemplate rest;
	
//	@Scheduled(cron="${scheduler.inactive.cron}")
	@Scheduled(fixedRate = 10000)
	@Async
	public void inactiveSubscription() {
//		schedulerService.inactiveSubscription();
		System.out.println(rest.getAllSubscriptions());
	}

}