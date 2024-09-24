package com.example.geektrust.constant;

public enum PlanType {
    FREE(StreamPlanConstant.FREE_PLAN_MONTHS),
    PERSONAL(StreamPlanConstant.PERSONAL_PLAN_MONTHS),
    PREMIUM(StreamPlanConstant.PREMIUM_PLAN_MONTHS);

    private final int months;

    PlanType(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }
}
