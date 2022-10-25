package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class StudentApp {

    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args);
    }

    @Value("${address.service.url}")
    private String addressUrl;

    @Bean
    public WebClient webClient() {
    WebClient webClient = WebClient.builder().baseUrl(addressUrl).build();
    return  webClient;
    }

}
