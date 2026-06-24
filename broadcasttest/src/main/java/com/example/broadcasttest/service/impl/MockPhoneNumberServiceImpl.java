package com.example.broadcasttest.service.impl;

import com.example.broadcasttest.model.Customer;
import com.example.broadcasttest.service.MockPhoneNumberService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MockPhoneNumberServiceImpl
        implements MockPhoneNumberService {

    private final Random random = new Random();

    @Override
    public boolean sendMessage(Customer customer) {

        try {

            Thread.sleep(
                    1000 + random.nextInt(1000)
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            return false;
        }

        return random.nextInt(100) >= 10;
    }
}