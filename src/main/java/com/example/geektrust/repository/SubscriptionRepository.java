package com.example.geektrust.repository;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.constant.TopUp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {
    private static SubscriptionRepository instance;
    private LocalDate startDate;
    private final List<Subscription> subscriptions;
    private TopUp topUp;
    private int topUpMonths;

    private SubscriptionRepository() {
        subscriptions = new ArrayList<>();
    }

    public static SubscriptionRepository getInstance() {
        if (instance == null)
            instance = new SubscriptionRepository();
        return instance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(TopUp topUp) {
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
