package com.cts.crm.scheduler;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintScheduler {

	@Scheduled(fixedRate = 100000)
	public void printConsole() {
		LocalTime time=LocalTime.now();
		System.out.println("Scheduler Triggered at Time: "+time);
	}
}
