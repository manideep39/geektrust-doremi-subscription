package com.example.geektrust.constant;

public enum TopUp {
    FOUR_DEVICE(50),
    TEN_DEVICE(100);

    private final int price;

    TopUp(int price) {
        this.price = price;
    }

    public int getPriceForSubMonths(int subMonths) {
        return price * subMonths;
    }
}
