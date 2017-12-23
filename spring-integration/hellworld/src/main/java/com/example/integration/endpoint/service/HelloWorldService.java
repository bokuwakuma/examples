package com.example.integration.endpoint.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public String sayHelllo(String name) {
        return String.format("Hello, %s!", name);
    }
}
