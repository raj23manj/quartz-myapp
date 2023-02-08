package com.scheduler.quartz.samplecode;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class PSI {
}




//
//        import lombok.extern.slf4j.Slf4j;
//        import org.quartz.DisallowConcurrentExecution;
//        import org.quartz.Job;
//        import org.quartz.JobExecutionContext;
//        import org.quartz.JobExecutionException;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@DisallowConcurrentExecution
//public class UpdateSkipPlanInstructionsJob implements Job {
//    @Autowired
//    private PlanSkipInstructionService planSkipInstructionService;
//
//    @Autowired
//    private TenantSettingRepository tenantSettingRepository;
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        final String jobKey = context.getJobDetail().getKey().toString();
//        log.info("Task {} execution started with firetime: {}", jobKey, context.getFireTime());
//
//        // running job for all configured tenants
//        for (TenantSetting tenantSetting : tenantSettingRepository.findAll()
//                .stream().filter(TenantSetting::runJobs).toList()) {
//            try {
//                TenantContext.setCurrentTenant(tenantSetting.getDomain());
//                this.planSkipInstructionService.enablePlanSkipInstructions();
//                this.planSkipInstructionService.disablePlanSkipInstructions();
//            } catch (Exception ex) {
//                log.error("Error occured in {} execution", jobKey);
//                Monit.newEvent().exception(ex).capture();
//            }
//        }
//
//        log.info("Task {} execution completed for firetime: {}", jobKey, context.getFireTime());
//    }
//}


// https://gist.github.com/mychalvlcek/f06864b3767e98b70fec904b7f5e6e3e