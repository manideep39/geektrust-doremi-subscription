package com.example.geektrust.model.topup;

public class TenDeviceTopUp extends AbstractTopUp {
    public TenDeviceTopUp(int months, int price) {
        super(months, price);
        deviceCount = 10;
        name = "TEN_DEVICE";
    }
}
