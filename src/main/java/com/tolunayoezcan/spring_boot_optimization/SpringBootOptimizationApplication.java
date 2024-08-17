package com.tolunayoezcan.spring_boot_optimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@EnableAsync
public class SpringBootOptimizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOptimizationApplication.class, args);
    }

}
