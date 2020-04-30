package com.cts.crm.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
//	@Scheduled(cron = "0 5 11 * * ?")
	public void inactiveSubscription() {
		List<Subscription> todaySubscriptions=dataServiceProxy.getAllSubscriptionsOfToday();
		if(todaySubscriptions.size()!=0) {
			todaySubscriptions.stream().forEach((subscription)->{
				int id=subscription.getId();
				dataServiceProxy.inactiveSubscription(id);
				log.info("Subscription: {} in now inactive.", id);
			});
		}
	}

}
