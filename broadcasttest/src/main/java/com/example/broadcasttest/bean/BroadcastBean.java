package com.example.broadcasttest.bean;

import com.example.broadcasttest.model.BroadcastStatus;
import com.example.broadcasttest.model.Customer;
import com.example.broadcasttest.service.BroadcastService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

@Named
@ViewScoped
public class BroadcastBean implements Serializable {

    @Inject
    private BroadcastService broadcastService;

    private List<Customer> customers;

    private boolean running;

    @PostConstruct
    public void init() {

        customers = new CopyOnWriteArrayList<>();

        IntStream.rangeClosed(1, 10)
                .forEach(i ->
                        customers.add(
                                new Customer(
                                        (long) i,
                                        "Customer " + i,
                                        "0812345678" + i,
                                        BroadcastStatus.PENDING
                                )
                        ));
    }

    public void startBroadcast() {

        running = true;

        List<CompletableFuture<Void>> futures =
                customers.stream()
                        .map(broadcastService::processCustomer)
                        .toList();

        CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        ).thenRun(() -> running = false);
    }

    public int getProgress() {

        long processed =
                customers.stream()
                        .filter(customer ->
                                customer.getStatus()
                                        != BroadcastStatus.PENDING)
                        .count();

        return (int) ((processed * 100) / customers.size());
    }

    public long getSuccessCount() {
        return customers.stream()
                .filter(c -> c.getStatus() == BroadcastStatus.SUCCESS)
                .count();
    }

    public long getFailedCount() {
        return customers.stream()
                .filter(c -> c.getStatus() == BroadcastStatus.FAILED)
                .count();
    }

    public long getPendingCount() {
        return customers.stream()
                .filter(c -> c.getStatus() == BroadcastStatus.PENDING)
                .count();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}