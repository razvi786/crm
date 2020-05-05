package com.cts.crm.scheduler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Demo {
	
	@Bean
	@Scheduled(fixedRate = 1000)
	@ConditionalOnProperty(prefix = "queries.jpa", name = "enable", matchIfMissing = false)
	public void run() {
		log.info("Scheduler Running...");
	}

}
