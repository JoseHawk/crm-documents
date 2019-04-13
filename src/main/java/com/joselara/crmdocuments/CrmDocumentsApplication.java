package com.joselara.crmdocuments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrmDocumentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmDocumentsApplication.class, args);
    }
}
