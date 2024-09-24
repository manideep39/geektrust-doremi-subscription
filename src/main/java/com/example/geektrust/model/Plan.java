package com.example.geektrust.model;

import com.example.geektrust.constant.PlanType;

public class Plan {
    private final PlanType planType;
    private final int price;

    public Plan(PlanType planType, int price) {
        this.planType = planType;
        this.price = price;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public int getMonths() {
        return planType.getMonths();
    }

    public int getPrice() {
        return price;
    }
}
