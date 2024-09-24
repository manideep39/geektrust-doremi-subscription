package com.example.geektrust.service.command;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.constant.StreamType;
import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.RenewalService;
import com.example.geektrust.service.SubscriptionService;

public class AddSubscriptionCommand implements Command {
    private final StreamType streamType;
    private final PlanType planType;

    public AddSubscriptionCommand(StreamType streamType, PlanType planType) {
        this.streamType = streamType;
        this.planType = planType;
    }

    public void execute() {
        try {
            Subscription sub = SubscriptionService.getInstance().saveSubscription(streamType, planType);
            String renewalDate = RenewalService.getInstance().getReminderDate(sub);
            PrintRenewalDetails.getInstance().saveAsRenewalReminderNote(streamType, renewalDate);
        } catch (SubscriptionException e) {
            PrintRenewalDetails.getInstance().saveAsErrorNote(e, true);
        }
    }
}
