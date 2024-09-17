package com.example.geektrust.model.plans;

public class PersonalPlan extends AbstractPlan {

    public PersonalPlan(int months, int price) {
        super(months, price);
        name = "PERSONAL";
    }
}
