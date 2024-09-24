package com.example.geektrust.constant;

public enum TopUp {
    FOUR_DEVICE(StreamPlanConstant.FOUR_DEVICE_TOPUP_PRICE),
    TEN_DEVICE(StreamPlanConstant.TEN_DEVICE_TOPUP_PRICE);

    private final int price;

    TopUp(int price) {
        this.price = price;
    }

    public int getPriceForSubMonths(int subMonths) {
        return price * subMonths;
    }
}
