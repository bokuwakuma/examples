package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.support.GenericMessage;

import com.example.config.IntegrationConfig;
import com.example.integration.message.User;

public class DatatypeChannelApp {

    private static final Logger logger = LoggerFactory.getLogger(DatatypeChannelApp.class);
    
    public static void main(String[] args) {
        try (AbstractApplicationContext context = 
                new AnnotationConfigApplicationContext(IntegrationConfig.class)) {
            
            DirectChannel inputChannel = context.getBean("inputChannel", DirectChannel.class);
            QueueChannel outputChannel = context.getBean("outputChannel", QueueChannel.class);
            
            User user = new User();
            user.setName("Spring Integration");
            
            inputChannel.send(new GenericMessage<User>(user));
            logger.info(outputChannel.receive().getPayload().toString());
            
            inputChannel.send(new GenericMessage<String>("Spring Integration"));
            logger.info(outputChannel.receive().getPayload().toString());
        }
    }
}
