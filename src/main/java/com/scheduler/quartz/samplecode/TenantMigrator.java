package com.scheduler.quartz.samplecode;


public class TenantMigrator {
}





//        import lombok.extern.slf4j.Slf4j;
//        import org.flywaydb.core.Flyway;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.beans.factory.annotation.Qualifier;
//        import org.springframework.beans.factory.annotation.Value;
//        import org.springframework.stereotype.Component;
//
//        import javax.annotation.PostConstruct;
//        import javax.sql.DataSource;
//        import java.util.List;
//
//@Slf4j
//@Component
//public class FlywaySchemaMigrator {
//
//    private final TenantSettingRepository tenantSettingRepository;
//
//    public FlywaySchemaMigrator(TenantSettingRepository tenantSettingRepository) {
//        this.tenantSettingRepository = tenantSettingRepository;
//    }
//
//    @Autowired
//    @Qualifier("dataSource")
//    private DataSource dataSource;
//
//    @Value("${spring.flyway.outOfOrder:true}")
//    private boolean outOfOrder;
//
//    @PostConstruct
//    private void init() {
//        //public schema migration
//        configureFlyway("public", "classpath:db/migration/public").migrate();
//        log.info("Public schema migrated");
//
//        List<TenantSetting> tenants = tenantSettingRepository.findAll();
//        if (tenants.isEmpty()) return;
//
//        //private schema migration
//        tenants.forEach(tenantSetting -> migrateTenant(tenantSetting.getDomain()));
//        log.info("Flyway App DB migration completed");
//    }
//
//    public void migrateTenant(String tenantDomain) {
//        configureFlyway(tenantDomain, "classpath:db/migration/schemas").migrate();
//    }
//
//    private Flyway configureFlyway(String schema, String location) {
//        return Flyway.configure()
//                .locations(location)
//                .schemas(schema)
//                .baselineOnMigrate(true)
//                .outOfOrder(outOfOrder)
//                .table("schema_version")
//                .dataSource(dataSource)
//                .load();
//    }
//}