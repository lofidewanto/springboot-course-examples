package com.example.demo.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Value("${application.cron.exp}")
	private String cronExp;

	@Autowired
	private AdresseService adresseService;

	@Scheduled(cron = "${application.cron.exp}")
	public void reportCurrentTime() throws InterruptedException, ExecutionException {
		logger.info("Cron: " + cronExp);

		logger.info("The time is now {}", dateFormat.format(new Date()));

		adresseService.callPerson();
	}
}
