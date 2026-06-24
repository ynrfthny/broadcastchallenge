package com.example.broadcasttest.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private Long id;
    private String name;
    private String phoneNumber;
    private BroadcastStatus status;

    public Customer() {
    }

    public Customer(Long id,
                    String name,
                    String phoneNumber,
                    BroadcastStatus status) {

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BroadcastStatus getStatus() {
        return status;
    }

    public void setStatus(BroadcastStatus status) {
        this.status = status;
    }
}