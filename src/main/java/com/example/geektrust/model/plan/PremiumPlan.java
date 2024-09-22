package com.example.geektrust.model.plan;

public class PremiumPlan extends AbstractPlan {

    public PremiumPlan(int months, int price) {
        super(months, price);
        name = "PREMIUM";
    }
}
