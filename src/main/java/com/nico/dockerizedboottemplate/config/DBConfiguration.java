package com.nico.dockerizedboottemplate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConn() {
        log.debug("DB connection for dev - H2 - driver {} - url {}", driverClassName, url);
        return "DB connection for dev - H2";
    }

    // prod and other environments configurations go here
}
