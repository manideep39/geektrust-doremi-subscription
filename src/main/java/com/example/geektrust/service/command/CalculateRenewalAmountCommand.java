package com.example.geektrust.service.command;

import com.example.geektrust.exception.SubscriptionException;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.RenewalService;

public class CalculateRenewalAmountCommand implements Command {
    @Override
    public void execute() {
        try {
            int renewalAmount = RenewalService.getInstance().getAmount();
            PrintRenewalDetails.getInstance().save("RENEWAL_AMOUNT " + renewalAmount);
        } catch (SubscriptionException e) {
            PrintRenewalDetails.getInstance().save(e.getMessage());
        }
    }
}
