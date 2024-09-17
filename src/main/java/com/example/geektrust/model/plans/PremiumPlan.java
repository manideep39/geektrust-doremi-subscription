package com.example.geektrust.model.plans;

public class PremiumPlan extends AbstractPlan {

    public PremiumPlan(int months, int price) {
        super(months, price);
        name = "PREMIUM";
    }
}
