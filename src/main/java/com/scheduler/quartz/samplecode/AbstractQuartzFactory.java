//package com.scheduler.quartz.samplecode;
//
//
//import com.cybrilla.mf.oms.schedulers.data.QuartzJobData;
//import com.cybrilla.mf.oms.utils.DateFormats;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.TimeZone;
//
//@Service
//@Slf4j
//public abstract class AbstractQuartzFactory {
//
//    /*
//    SchedulerFactoryBean for Scheduler.
//     */
//    protected SchedulerFactoryBean schedulerFactoryBean;
//
//    public AbstractQuartzFactory(SchedulerFactoryBean schedulerFactoryBean) {
//        this.schedulerFactoryBean = schedulerFactoryBean;
//    }
//
//    protected abstract boolean createJob(final QuartzJobData jobData) throws SchedulerException, ClassNotFoundException;
//
//    public boolean toggleScheduler() throws SchedulerException {
//        final Scheduler scheduler = schedulerFactoryBean.getScheduler();
//        if (scheduler.isInStandbyMode()) {
//            scheduler.start();
//        } else {
//            scheduler.standby();
//        }
//        return true;
//    }
//
//
//
//    /*
//     * #########################################
//     * ############ Utility methods ############
//     * #########################################
//     */
//    protected JobDetail createJobDetail(final QuartzJobData job, boolean isDurable) throws ClassNotFoundException {
//        return createJobDetail(
//                job.getJobClass(),
//                new JobKey(job.getJobName(), job.getJobGroup()),
//                job.getJobDesc(),
//                job.getJobDataMap(),
//                isDurable
//        );
//    }
//
//    protected JobDetail createJobDetail(final QuartzJobData job) throws ClassNotFoundException {
//        return createJobDetail(
//                job.getJobClass(),
//                new JobKey(job.getJobName(), job.getJobGroup()),
//                job.getJobDesc(),
//                job.getJobDataMap(),
//                true
//        );
//    }
//
//    protected static JobDetail createJobDetail(final Class<? extends Job> jobClass,
//                                               final JobKey jobKey,
//                                               final String jobDesc,
//                                               final Map<String, String> jobDatMap, boolean isDurable) {
//        return JobBuilder.newJob()
//                .withIdentity(jobKey)
//                .ofType(jobClass)
//                .storeDurably(isDurable)
//                .withDescription(jobDesc)
//                .usingJobData(new JobDataMap(jobDatMap))
//                .requestRecovery(true)
//                .build();
//    }
//
//
//    protected static SimpleTrigger createSimpleTrigger(final JobDetail jobDetail,
//                                                       final TriggerKey triggerKey,
//                                                       final String triggerDesc,
//                                                       final Map<String, String> triggerDatMap,
//                                                       final Date triggerStartDate,
//                                                       final int priority) {
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail)
//                .withIdentity(triggerKey)
//                .withDescription(triggerDesc)
//                .usingJobData(new JobDataMap(triggerDatMap))
//                .startAt(triggerStartDate)
//                .withSchedule(SimpleScheduleBuilder
//                        .simpleSchedule()
//                        .withMisfireHandlingInstructionFireNow())
//                .withPriority(priority)
//                .build();
//    }
//
//    protected static CronTrigger createCronTrigger(final JobDetail jobDetail,
//                                                   final TriggerKey triggerKey,
//                                                   final String triggerDesc,
//                                                   final Map<String, String> triggerDatMap,
//                                                   final String cronExpression, final int priority) {
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail)
//                .withIdentity(triggerKey)
//                .withDescription(triggerDesc)
//                .usingJobData(new JobDataMap(triggerDatMap))
//                .withSchedule(CronScheduleBuilder
//                        .cronSchedule(cronExpression)
//                        .inTimeZone(TimeZone.getTimeZone(DateFormats.ASIA_KOLKATTA_ZONE))
//                        .withMisfireHandlingInstructionFireAndProceed())
//                .withPriority(priority)
//                .build();
//    }
//
//}
