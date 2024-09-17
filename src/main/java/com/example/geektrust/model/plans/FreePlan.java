package com.example.geektrust.model.plans;

public class FreePlan extends AbstractPlan {
    public FreePlan(int months, int price) {
        super(months, price);
        name = "FREE";
    }
}
