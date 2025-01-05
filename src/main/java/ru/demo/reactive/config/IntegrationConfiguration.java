package ru.demo.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class IntegrationConfiguration {

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder().build();
    }
}
