package com.example.geektrust.service;

import com.example.geektrust.constant.OutputMessageConstant;
import com.example.geektrust.constant.StreamType;

public class PrintRenewalDetails {
    private static PrintRenewalDetails instance;
    private final StringBuilder builder;

    private PrintRenewalDetails() {
        builder = new StringBuilder();
    }

    public static PrintRenewalDetails getInstance() {
        if (instance == null)
            instance = new PrintRenewalDetails();
        return instance;
    }

    public void saveAsRenewalReminderNote(StreamType streamType, String renewalDate) {
        builder.append(OutputMessageConstant.RENEWAL_REMINDER).append(" ")
                .append(streamType.name()).append(" ")
                .append(renewalDate)
                .append(System.lineSeparator());
    }

    public void saveAsErrorNote(RuntimeException e, boolean lineSeparator) {
        builder.append(e.getMessage());
        if (lineSeparator)
            builder.append(System.lineSeparator());
    }

    public void saveAsRenewalAmountNote(int renewalAmount) {
        builder.append(OutputMessageConstant.RENEWAL_AMOUNT).append(" ").append(renewalAmount);
    }

    public void printOutput() {
        System.out.println(builder);
    }
}
