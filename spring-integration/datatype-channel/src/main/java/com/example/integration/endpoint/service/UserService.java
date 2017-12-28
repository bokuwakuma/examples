package com.example.integration.endpoint.service;

import java.util.UUID;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.example.domain.object.User;

@Component
public class UserService {

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public User setId(User user) {
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
