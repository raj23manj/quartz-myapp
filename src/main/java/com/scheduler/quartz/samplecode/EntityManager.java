package com.scheduler.quartz.samplecode;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EntityManager {
}


//
//
//        import com.google.common.base.Strings;
//        import lombok.extern.slf4j.Slf4j;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//        import javax.persistence.EntityManager;
//        import java.time.LocalDate;
//        import java.util.HashMap;
//        import java.util.Map;
//
//@Service
//@Slf4j
//public class PartnerMigrator {
//
//    @Autowired
//    private TenantSettingRepository tenantSettingRepository;
//    @Autowired
//    private PartnerDataService partnerDataService;
//    @Autowired
//    private TransactionHandler transactionHandler;
//    @Autowired
//    private EntityManager entityManager;
//
//    public void migrateTenantSettingsToPartner(TenantSetting tenantSetting) {
//        if (Strings.isNullOrEmpty(tenantSetting.getArnCode()) && Strings.isNullOrEmpty(tenantSetting.getRiaCode())) return;
//        //Build distributor for each tenant
//        .......
//
//        transactionHandler.runInNewTransaction(() -> {
//            Distributor distributor = partnerDataService.findByLicenseCode(partnerRequestItem.getLicenseCode());
//            distributor = distributor != null ?
//                    partnerDataService.update(partnerRequestItem, distributor) :
//                    partnerDataService.create(partnerRequestItem);
//            log.info("Distributor created for tenant:: {} with id:: {}", tenantSetting.getDomain(), distributor.getId());
//
//            Long distributorId = distributor.getId();
//            entityManager.createQuery("Update AmcOrder set distributor = ?1, euin = ?2 " +
//                            "where distributor is null").setParameter(1, distributor)
//                    .setParameter(2, tenantSetting.getDefaultEuin())
//                    .executeUpdate();
//
//            entityManager.createQuery("Update Plan set distributor = ?1, euin = ?2  " +
//                            "where distributor is null").setParameter(1, distributor)
//                    .setParameter(2, tenantSetting.getDefaultEuin())
//                    .executeUpdate();
//
//            entityManager.createQuery("Update Transaction set distributor = ?1  " +
//                            "where distributor is null").setParameter(1, distributor)
//                    .executeUpdate();
//
//            log.info("Updated exiting records for amc_orders, plans and transactions" +
//                    " with distributor_id: {} for tenant: {}", distributorId, tenantSetting.getDomain());
//
//
//            //Update tenant setting version to V1.1
//            tenantSetting.setEntityVersion("V1.1");
//            tenantSettingRepository.save(tenantSetting);
//            return true;
//        });
//    }
//}
