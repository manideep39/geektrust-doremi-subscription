package com.example.geektrust.service;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.plans.AbstractPlan;
import com.example.geektrust.model.streams.AbstractStream;
import com.example.geektrust.model.topups.AbstractTopUp;
import com.example.geektrust.repository.StreamRepository;
import com.example.geektrust.repository.SubscriptionRepository;
import com.example.geektrust.repository.TopUpRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SubscriptionService {
    private final StreamRepository streamRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final TopUpRepository topUpRepository;

    public SubscriptionService(SubscriptionRepository subRepo) {
        streamRepository = new StreamRepository();
        subscriptionRepository = subRepo;
        topUpRepository = new TopUpRepository();
    }

    public void saveSubscriptionStartDate(String dateString) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            subscriptionRepository.setStartDate(date);
        } catch (DateTimeException e) {
            throw new Exception("INVALID_DATE");
        }
    }

    private boolean isDuplicateStream(AbstractStream stream) {
        for (Subscription sub: subscriptionRepository.getSubscriptions()) {
            if (sub.getStream().equals(stream))
                return true;
        }
        return false;
    }

    public Subscription saveSubscription(String streamType, String planType) throws Exception {
        if (subscriptionRepository.getStartDate() == null)
            throw new Exception("ADD_SUBSCRIPTION_FAILED INVALID_DATE");

        AbstractStream stream = streamRepository.getStream(streamType);

        if (isDuplicateStream(stream))
            throw new Exception("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");

        AbstractPlan plan = streamRepository.getPlan(stream, planType);
        LocalDate startDate = subscriptionRepository.getStartDate();

        Subscription sub = new Subscription(startDate, stream, plan);
        subscriptionRepository.addSubscription(sub);
        return sub;
    }

    public void saveTopUp(String topUpType, int topUpMonths) throws Exception {
        if (subscriptionRepository.getSubscriptions().isEmpty())
            throw new Exception("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");

        if (subscriptionRepository.getTopUp() != null)
            throw new Exception("ADD_TOPUP_FAILED DUPLICATE_TOPUP");

        AbstractTopUp topUp = topUpRepository.getToUp(topUpType);
        subscriptionRepository.setTopUp(topUp);
        subscriptionRepository.setTopUpMonths(topUpMonths);
    }

}
