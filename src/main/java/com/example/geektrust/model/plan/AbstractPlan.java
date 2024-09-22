package com.example.geektrust.model.plan;

public abstract class AbstractPlan {
    protected int months;
    protected int price;
    protected String name;

    protected AbstractPlan(int months, int price) {
        this.months = months;
        this.price = price;
    }

    public int getMonths() {
        return months;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
