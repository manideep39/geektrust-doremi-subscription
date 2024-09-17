package com.example.geektrust.controller;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.repository.SubscriptionRepository;
import com.example.geektrust.service.RenewalService;
import com.example.geektrust.service.SubscriptionService;


public class SubscriptionController {
    private final SubscriptionService subServ;
    private final RenewalService renServ;
    private final StringBuilder output;

    public SubscriptionController() {
        SubscriptionRepository subRepo = new SubscriptionRepository();
        subServ = new SubscriptionService(subRepo);
        renServ = new RenewalService(subRepo);
        output = new StringBuilder();
    }

    public void handleCommands(String[] commandArgs) {
        switch (commandArgs[0]) {
            case "START_SUBSCRIPTION":
                String dateString = commandArgs[1];
                startSubscription(dateString);
                break;
            case "ADD_SUBSCRIPTION":
                String serviceType = commandArgs[1];
                String planType = commandArgs[2];
                addSubscription(serviceType, planType);
                break;
            case "ADD_TOPUP":
                String toUpType = commandArgs[1];
                int months = commandArgs.length == 2 ? 1 : Integer.parseInt(commandArgs[2]);
                addTopUp(toUpType, months);
                break;
            case "PRINT_RENEWAL_DETAILS":
                getRenewalAmount();
                printRenewalDetails();
                break;
        }
    }

    private void startSubscription(String dateString) {
        try {
            subServ.saveSubscriptionStartDate(dateString);
        } catch (Exception e) {
            output.append(e.getMessage()).append("\n");
        }
    }

    private void addSubscription(String streamType, String planType) {
        try {
            Subscription sub = subServ.saveSubscription(streamType, planType);
            String renewalDate = renServ.getReminderDate(sub);
            output.append("ADD_SUBSCRIPTION").append(" ")
                    .append(streamType).append(" ")
                    .append(renewalDate).append("\n");
        } catch (Exception e) {
            output.append(e.getMessage()).append("\n");
        }
    }

    private void addTopUp(String topUpType, int topUpMonths) {
        try {
            subServ.saveTopUp(topUpType, topUpMonths);
        } catch (Exception e) {
            output.append(e.getMessage()).append("\n");
        }
    }

    private void getRenewalAmount() {
        try {
            int renewalAmount = renServ.getAmount();
            output.append("RENEWAL_AMOUNT").append(" ").append(renewalAmount);
        } catch (Exception e) {
            output.append(e.getMessage());
        }
    }

    private void printRenewalDetails() {
        System.out.println(output);
    }
}
