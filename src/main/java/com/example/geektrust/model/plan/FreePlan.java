package com.example.geektrust.model.plan;

public class FreePlan extends AbstractPlan {
    public FreePlan(int months, int price) {
        super(months, price);
        name = "FREE";
    }
}
