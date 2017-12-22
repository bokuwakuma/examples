package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

@Configuration
@EnableIntegration
@ComponentScan("com.example.service")
public class AppConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public PollableChannel outputChannel() {
        return new QueueChannel(10);
    }
}
