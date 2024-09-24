package com.example.geektrust.service.command;

import com.example.geektrust.exception.TopUpException;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.SubscriptionService;
import com.example.geektrust.constant.TopUp;

public class AddTopUpCommand implements Command {
    private final TopUp topUp;
    private final int topUpMonths;

    public AddTopUpCommand(TopUp topUp, int topUpMonths) {
        this.topUp = topUp;
        this.topUpMonths = topUpMonths;
    }

    public void execute() {
        try {
            SubscriptionService.getInstance().saveTopUp(topUp, topUpMonths);
        } catch (TopUpException e) {
            PrintRenewalDetails.getInstance().save(e.getMessage() + "\n");
        }
    }
}
