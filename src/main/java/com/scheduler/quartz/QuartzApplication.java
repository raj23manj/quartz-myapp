package com.scheduler.quartz;

import com.scheduler.quartz.jobs.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class QuartzApplication {

	public static void main(String[] args) {

		SpringApplication.run(QuartzApplication.class, args);
	}

	@Bean()
	public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		return scheduler;
	}

	@Bean
	public CommandLineRunner run(Scheduler scheduler) {
		return (String[] args) -> {
			JobDetail job = JobBuilder.newJob(SimpleJob.class)
					.usingJobData("param", "value") // add a parameter
					.build();

			Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5)
					.atZone(ZoneId.systemDefault()).toInstant());
			Trigger trigger = TriggerBuilder.newTrigger()
					.startAt(afterFiveSeconds)
					.build();

			scheduler.scheduleJob(job, trigger);
		};
	}

}

