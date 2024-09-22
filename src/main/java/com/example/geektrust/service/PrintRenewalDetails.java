package com.example.geektrust.service;

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

    public void save(String input) {
        builder.append(input);
    }

    public void printOutput() {
        System.out.println(builder);
    }
}
