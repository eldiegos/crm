package io.code.crm.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "io.code.crm.core")
@EnableJpaRepositories(basePackages = "io.code.crm.core")
@PropertySource(value = {"db-h2.properties"})
public class LoadCrmCore {
    
}
