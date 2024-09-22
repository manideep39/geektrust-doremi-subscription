package com.example.geektrust.service.command;

import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.RenewalService;
import com.example.geektrust.service.SubscriptionService;

public class AddSubscriptionCommand implements Command {
    private final String streamType;
    private final String planType;

    public AddSubscriptionCommand(String streamType, String planType) {
        this.streamType = streamType;
        this.planType = planType;
    }

    public void execute() {
        try {
            Subscription sub = SubscriptionService.getInstance().saveSubscription(streamType, planType);
            String renewalDate = RenewalService.getInstance().getReminderDate(sub);
            PrintRenewalDetails.getInstance().save("ADD_SUBSCRIPTION " + streamType + " " + renewalDate + "\n");
        } catch (SubscriptionException e) {
            PrintRenewalDetails.getInstance().save(e.getMessage() + "\n");
        }
    }
}
