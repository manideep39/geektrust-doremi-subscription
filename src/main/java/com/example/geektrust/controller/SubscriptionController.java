package com.example.geektrust.controller;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.constant.StreamType;
import com.example.geektrust.service.PrintRenewalDetails;
import com.example.geektrust.service.command.AddSubscriptionCommand;
import com.example.geektrust.service.command.AddTopUpCommand;
import com.example.geektrust.service.command.CalculateRenewalAmountCommand;
import com.example.geektrust.service.command.StartSubscriptionCommand;
import com.example.geektrust.service.invoker.SubscriptionInvoker;
import com.example.geektrust.constant.InputCommand;
import com.example.geektrust.constant.TopUp;


public class SubscriptionController {
    private final SubscriptionInvoker subInvoker;

    public SubscriptionController() {
        subInvoker = SubscriptionInvoker.getInstance();
    }

    public void handleCommands(String[] commandArgs) {
        InputCommand command = InputCommand.valueOf(commandArgs[0]);
        switch (command) {
            case START_SUBSCRIPTION:
                String dateString = commandArgs[1];
                subInvoker.queueCommand(new StartSubscriptionCommand(dateString));
                break;
            case ADD_SUBSCRIPTION:
                StreamType streamType = StreamType.valueOf(commandArgs[1]);
                PlanType planType = PlanType.valueOf(commandArgs[2]);
                subInvoker.queueCommand(new AddSubscriptionCommand(streamType, planType));
                break;
            case ADD_TOPUP:
                TopUp topUp = TopUp.valueOf(commandArgs[1]);
                int topUpMonths = commandArgs.length == 2 ? 1 : Integer.parseInt(commandArgs[2]);
                subInvoker.queueCommand(new AddTopUpCommand(topUp, topUpMonths));
                break;
            case PRINT_RENEWAL_DETAILS:
                subInvoker.queueCommand(new CalculateRenewalAmountCommand());
                subInvoker.executeCommands();
                PrintRenewalDetails.getInstance().printOutput();
                break;
        }
    }
}
