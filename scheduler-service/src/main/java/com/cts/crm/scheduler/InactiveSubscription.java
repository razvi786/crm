//package com.cts.crm.scheduler;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.cts.crm.service.proxy.DataServiceProxy;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class InactiveSubscription {
//	
//	@Autowired
//	DataServiceProxy dataServiceProxy;
//	
//	@Scheduled(fixedRate = 60000)
//	public void inactiveSubscription() {
//		int id=1;
//		dataServiceProxy.inactiveSubscription(id);
//		log.info("Subscription: {} in now inactive.", id);
//	}
//
//}
