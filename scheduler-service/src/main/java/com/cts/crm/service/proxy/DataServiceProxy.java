package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.crm.model.Subscription;

@FeignClient(name="data-service")
@RibbonClient(name="data-service")
public interface DataServiceProxy {
	
	@GetMapping("inactive-subscription/{id}")
	public void inactiveSubscription(@PathVariable int id);
	
	@GetMapping("get-today-subscriptions")
	public List<Subscription> getAllSubscriptionsOfToday();

}
