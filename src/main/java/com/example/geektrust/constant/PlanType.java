package com.example.geektrust.constant;

public enum PlanType {
    FREE(1),
    PERSONAL(1),
    PREMIUM(3);

    private final int months;

    PlanType(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }
}
