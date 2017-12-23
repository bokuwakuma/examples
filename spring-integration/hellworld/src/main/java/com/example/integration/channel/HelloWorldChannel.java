package com.example.integration.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldChannel {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }
    
    @Bean
    public PollableChannel outputChannel() {
        return new QueueChannel(10);
    }
}
