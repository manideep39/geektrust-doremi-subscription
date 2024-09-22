package com.example.geektrust.model.topup;

public abstract class AbstractTopUp {
    protected int deviceCount;
    protected final int months;
    protected final int price;
    protected String name;

    public AbstractTopUp(int months, int price) {
        this.months = months;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
