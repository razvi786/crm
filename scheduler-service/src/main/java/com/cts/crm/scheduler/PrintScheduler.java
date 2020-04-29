package com.cts.crm.scheduler;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PrintScheduler {

	@Scheduled(fixedRate = 60000)
	public void printConsole() {
		LocalTime time=LocalTime.now();
		log.info("Scheduler Triggered at Time: {}", time);
	}
	
}
