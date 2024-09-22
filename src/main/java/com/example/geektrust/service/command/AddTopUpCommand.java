package com.example.geektrust.service.command;

import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.SubscriptionService;

public class AddTopUpCommand implements Command {
    private final String topUpType;
    private final int topUpMonths;

    public AddTopUpCommand(String topUpType, int topUpMonths) {
        this.topUpType = topUpType;
        this.topUpMonths = topUpMonths;
    }

    public void execute() {
        try {
            SubscriptionService.getInstance().saveTopUp(topUpType, topUpMonths);
        } catch (Exception e) {
            PrintRenewalDetails.getInstance().save(e.getMessage() + "\n");
        }
    }
}
