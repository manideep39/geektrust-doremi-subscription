package com.example.geektrust.service;

import com.example.geektrust.constant.ErrorMessageConstant;
import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.exception.TopUpException;
import com.example.geektrust.exception.StartDateException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.plan.AbstractPlan;
import com.example.geektrust.model.stream.AbstractStream;
import com.example.geektrust.constant.TopUp;
import com.example.geektrust.repository.StreamRepository;
import com.example.geektrust.repository.SubscriptionRepository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SubscriptionService {
    private static SubscriptionService instance;
    private final StreamRepository streamRepository;
    private final SubscriptionRepository subscriptionRepository;

    private SubscriptionService() {
        streamRepository = StreamRepository.getInstance();
        subscriptionRepository = SubscriptionRepository.getInstance();
    }

    public static SubscriptionService getInstance() {
        if (instance == null)
            instance = new SubscriptionService();
        return instance;
    }

    public void saveSubscriptionStartDate(String dateString) throws StartDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate date = LocalDate.parse(dateString, formatter);
            subscriptionRepository.setStartDate(date);
        } catch (DateTimeException e) {
            throw new StartDateException(ErrorMessageConstant.INVALID_DATE);
        }
    }

    private boolean isDuplicateStream(AbstractStream stream) {
        for (Subscription sub: subscriptionRepository.getSubscriptions()) {
            if (sub.getStream().equals(stream))
                return true;
        }
        return false;
    }

    public Subscription saveSubscription(String streamType, String planType) throws SubscriptionException {
        if (subscriptionRepository.getStartDate() == null)
            throw new SubscriptionException(ErrorMessageConstant.ADD_SUBSCRIPTION_FAILED_INVALID_DATE);

        AbstractStream stream = streamRepository.getStream(streamType);

        if (isDuplicateStream(stream))
            throw new SubscriptionException(ErrorMessageConstant.ADD_SUBSCRIPTION_FAILED_DUPLICATE_CATEGORY);

        AbstractPlan plan = streamRepository.getPlan(stream, planType);
        LocalDate startDate = subscriptionRepository.getStartDate();

        Subscription sub = new Subscription(startDate, stream, plan);
        subscriptionRepository.addSubscription(sub);
        return sub;
    }

    public void saveTopUp(TopUp topUp, int topUpMonths) throws TopUpException {
        if (subscriptionRepository.getSubscriptions().isEmpty())
            throw new TopUpException(ErrorMessageConstant.ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND);

        if (subscriptionRepository.getTopUp() != null)
            throw new TopUpException(ErrorMessageConstant.ADD_TOPUP_FAILED_DUPLICATE_TOPUP);

        subscriptionRepository.setTopUp(topUp);
        subscriptionRepository.setTopUpMonths(topUpMonths);
    }

}
