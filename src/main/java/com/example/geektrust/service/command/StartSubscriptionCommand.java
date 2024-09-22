package com.example.geektrust.service.command;

import com.example.geektrust.exception.StartDateException;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.SubscriptionService;

public class StartSubscriptionCommand implements Command {
    private final String dateString;

    public StartSubscriptionCommand(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public void execute() {
        try {
            SubscriptionService.getInstance().saveSubscriptionStartDate(dateString);
        } catch (StartDateException e) {
            PrintRenewalDetails.getInstance().save(e.getMessage() + "\n");
        }
    }
}
