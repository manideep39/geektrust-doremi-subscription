package com.example.geektrust.controller;

import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.command.AddSubscriptionCommand;
import com.example.geektrust.service.command.AddTopUpCommand;
import com.example.geektrust.service.command.CalculateRenewalAmountCommand;
import com.example.geektrust.service.command.StartSubscriptionCommand;
import com.example.geektrust.service.invoker.CommandInvoker;
import com.example.geektrust.constant.InputCommand;


public class SubscriptionController {
    private final CommandInvoker cmdInvoker;

    public SubscriptionController() {
        cmdInvoker = CommandInvoker.getInstance();
    }

    public void handleCommands(String[] commandArgs) {
        InputCommand command = InputCommand.valueOf(commandArgs[0]);
        switch (command) {
            case START_SUBSCRIPTION:
                String dateString = commandArgs[1];
                cmdInvoker.queueCommand(new StartSubscriptionCommand(dateString));
                break;
            case ADD_SUBSCRIPTION:
                String serviceType = commandArgs[1];
                String planType = commandArgs[2];
                cmdInvoker.queueCommand(new AddSubscriptionCommand(serviceType, planType));
                break;
            case ADD_TOPUP:
                String toUpType = commandArgs[1];
                int topUpMonths = commandArgs.length == 2 ? 1 : Integer.parseInt(commandArgs[2]);
                cmdInvoker.queueCommand(new AddTopUpCommand(toUpType, topUpMonths));
                break;
            case PRINT_RENEWAL_DETAILS:
                cmdInvoker.queueCommand(new CalculateRenewalAmountCommand());
                cmdInvoker.executeCommands();
                PrintRenewalDetails.getInstance().printOutput();
                break;
        }
    }
}
