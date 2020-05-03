package com.cts.crm.service.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.crm.model.Subscription;

@FeignClient(name="data-service")
@RibbonClient(name="data-service")
public interface DataServiceProxy {
	
	@PostMapping("inactive-subscription/batch")
	public ResponseEntity<Object> batchInactiveSubscriptions(@RequestBody List<Subscription> subscriptions);
	
	@GetMapping("get-all-subscriptions")
	public ResponseEntity<List<Subscription>> getAllSubscriptions();

}
