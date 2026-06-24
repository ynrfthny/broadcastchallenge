package com.example.broadcasttest.service;

import com.example.broadcasttest.model.Customer;

public interface MockPhoneNumberService {

    boolean sendMessage(Customer customer);

}