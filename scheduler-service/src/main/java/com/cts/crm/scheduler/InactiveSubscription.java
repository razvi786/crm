package com.cts.crm.scheduler;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cts.crm.model.Subscription;
import com.cts.crm.service.proxy.DataServiceProxy;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InactiveSubscription {
	
	@Autowired
	DataServiceProxy dataServiceProxy;
	
	//https://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm
	@Scheduled(cron = "0 5 0 * * ?")
//	@Scheduled(fixedRate = 10000)
	public void inactiveSubscription() {
		List<Subscription> subscriptions=dataServiceProxy.getAllSubscriptions().getBody();
		List<Subscription> todaySubscriptions = subscriptions.parallelStream().filter((sub)->sub.getExpiryDate()
				.toLocalDate().equals(LocalDate.now()))
				.collect(Collectors.toList());
		dataServiceProxy.batchInactiveSubscriptions(todaySubscriptions);
		todaySubscriptions.forEach((sub)->log.info("Subscription: {} is now inactive", sub.getId()));
	}

}
