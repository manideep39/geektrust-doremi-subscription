package com.example.geektrust.repository;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.topups.AbstractTopUp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {
    private LocalDate startDate;
    private final List<Subscription> subscriptions;
    private AbstractTopUp topUp;
    private int topUpMonths;

    public SubscriptionRepository() {
        subscriptions = new ArrayList<>();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public AbstractTopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(AbstractTopUp topUp) {
        this.topUp = topUp;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription sub) {
        subscriptions.add(sub);
    }

    public int getTopUpMonths() {
        return topUpMonths;
    }

    public void setTopUpMonths(int topUpMonths) {
        this.topUpMonths = topUpMonths;
    }
}
