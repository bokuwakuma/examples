package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

import com.example.config.IntegrationConfig;

public class HelloWorld {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        try (AbstractApplicationContext context = 
                new AnnotationConfigApplicationContext(IntegrationConfig.class)) {
            
            MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
            PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);

            inputChannel.send(new GenericMessage<String>("Spring Integration"));
            logger.info(outputChannel.receive().getPayload().toString());
        }
    }
}
