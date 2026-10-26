package com.klef.soa.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThemeParkServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkServiceApplication.class, args);
        
        System.out.println("Theme Park Service is running");
   }
}
