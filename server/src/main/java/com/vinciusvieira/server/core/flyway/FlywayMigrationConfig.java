package com.vinciusvieira.server.core.flyway;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Caso ocorra algum erro durante a migration, não salva o arquivo sql.
 */
@Configuration
public class FlywayMigrationConfig {
    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(){
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
