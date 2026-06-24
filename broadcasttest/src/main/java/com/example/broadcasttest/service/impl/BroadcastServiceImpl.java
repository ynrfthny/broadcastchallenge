package com.example.broadcasttest.service.impl;

import com.example.broadcasttest.model.BroadcastStatus;
import com.example.broadcasttest.model.Customer;
import com.example.broadcasttest.service.BroadcastService;
import com.example.broadcasttest.service.MockPhoneNumberService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BroadcastServiceImpl implements BroadcastService {

    private final MockPhoneNumberService mockWhatsappService;

    public BroadcastServiceImpl(
            MockPhoneNumberService mockWhatsappService) {

        this.mockWhatsappService = mockWhatsappService;
    }

    @Override
    @Async("broadcastExecutor")
    public CompletableFuture<Void> processCustomer(
            Customer customer) {

        customer.setStatus(
                BroadcastStatus.PROCESSING
        );

        boolean success =
                mockWhatsappService.sendMessage(customer);

        customer.setStatus(
                success
                        ? BroadcastStatus.SUCCESS
                        : BroadcastStatus.FAILED
        );

        return CompletableFuture.completedFuture(null);
    }
}