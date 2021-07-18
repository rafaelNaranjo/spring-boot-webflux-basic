package com.rafaelnaranjo.pbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@AutoConfigurationPackage
public class PbbApplication {

    public static void main(String[] args) {
        SpringApplication.run(PbbApplication.class, args);
    }

}
