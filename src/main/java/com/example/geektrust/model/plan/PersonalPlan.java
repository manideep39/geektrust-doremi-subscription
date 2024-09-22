package com.example.geektrust.model.plan;

public class PersonalPlan extends AbstractPlan {

    public PersonalPlan(int months, int price) {
        super(months, price);
        name = "PERSONAL";
    }
}
