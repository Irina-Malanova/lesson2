package com.lesson2.cart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.lesson2.cart.shop")
public class ApplicatioConfiguration {
    @Bean
    public String getString() {
        return "Test string";
    }
}
