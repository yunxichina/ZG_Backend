package com.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *cyq
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class LawyerCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(LawyerCenterApp.class, args);
    }
}
