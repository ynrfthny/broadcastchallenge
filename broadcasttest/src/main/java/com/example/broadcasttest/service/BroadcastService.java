package com.example.broadcasttest.service;

import com.example.broadcasttest.model.Customer;

import java.util.concurrent.CompletableFuture;

public interface BroadcastService {

    CompletableFuture<Void> processCustomer(Customer customer);

}