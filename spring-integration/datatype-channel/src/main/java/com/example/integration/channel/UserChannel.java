package com.example.integration.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.stereotype.Component;

import com.example.domain.object.User;

@Component
public class UserChannel {

    @Bean
    public DirectChannel inputChannel() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setDatatypes(User.class);
        return directChannel;
    }
    
    @Bean
    public QueueChannel outputChannel() {
        return new QueueChannel(10);
    }
}
