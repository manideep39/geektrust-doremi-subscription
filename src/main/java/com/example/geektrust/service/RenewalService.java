package com.example.geektrust.service;

import com.example.geektrust.constant.ErrorMessageConstant;
import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.constant.TopUp;
import com.example.geektrust.repository.SubscriptionRepository;
import com.example.geektrust.constant.StreamPlanConstant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RenewalService {
    private static RenewalService instance;
    private final SubscriptionRepository subRepo;

    private RenewalService() {
        this.subRepo = SubscriptionRepository.getInstance();
    }

    public static RenewalService getInstance() {
        if (instance == null)
            instance = new RenewalService();
        return instance;
    }

    public String getReminderDate(Subscription sub) {
        int planMonths = sub.getPlan().getMonths();
        LocalDate reminderDate = sub.getStartDate().plusMonths(planMonths)
                .minusDays(StreamPlanConstant.DAYS_BEFORE_PLAN_EXPIRY);
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
        TopUp topUp = subRepo.getTopUp();
        int months = subRepo.getTopUpMonths();
        amount += topUp.getPriceForSubMonths(months);
        return amount;
    }

    public int getAmount() throws SubscriptionException {
        if (subRepo.getSubscriptions().isEmpty())
            throw new SubscriptionException(ErrorMessageConstant.SUBSCRIPTIONS_NOT_FOUND);
        return streamAmount() + topUpAmount();
    }
}
