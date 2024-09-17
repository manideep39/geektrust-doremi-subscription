package com.example.geektrust.model.topups;

public class FourDeviceTopUp extends AbstractTopUp {
    public FourDeviceTopUp(int months, int price) {
        super(months, price);
        deviceCount = 4;
        name = "FOUR_DEVICE";
    }
}
