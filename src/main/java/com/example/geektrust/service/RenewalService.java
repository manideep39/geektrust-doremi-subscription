package com.example.geektrust.service;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.topups.AbstractTopUp;
import com.example.geektrust.repository.SubscriptionRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RenewalService {
    private final SubscriptionRepository subRepo;

    public RenewalService(SubscriptionRepository subRepo) {
        this.subRepo = subRepo;
    }

    public String getReminderDate(Subscription sub) {
        int planMonths = sub.getPlan().getMonths();
        LocalDate reminderDate = sub.getStartDate().plusMonths(planMonths)
                .minusDays(ServiceConstants.DAYS_BEFORE_PLAN_EXPIRY);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return reminderDate.format(formatter);
    }

    public int streamAmount() {
        int amount = 0;
        for (Subscription sub: subRepo.getSubscriptions())
            amount += sub.getPlan().getPrice();
        return amount;
    }

    public int topUpAmount() {
        int amount = 0;
        AbstractTopUp topUp = subRepo.getTopUp();
        int months = subRepo.getTopUpMonths();
        amount += topUp == null ? 0 : topUp.getPrice() * months;
        return amount;
    }

    public int getAmount() throws Exception {
        if (subRepo.getSubscriptions().isEmpty())
            throw new Exception("SUBSCRIPTIONS_NOT_FOUND");
        return streamAmount() + topUpAmount();
    }
}
