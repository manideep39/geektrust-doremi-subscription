package com.example.geektrust.repository;

import com.example.geektrust.model.topup.AbstractTopUp;
import com.example.geektrust.model.topup.FourDeviceTopUp;
import com.example.geektrust.model.topup.TenDeviceTopUp;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class TopUpRepository {
    private static TopUpRepository instance;
    private final List<AbstractTopUp> topUps;

    private TopUpRepository() {
        topUps = Arrays.asList(
                new FourDeviceTopUp(StreamPlanConstant.STANDARD_TOPUP_MONTHS,
                        StreamPlanConstant.FOUR_DEVICE_TOPUP_PRICE),
                new TenDeviceTopUp(StreamPlanConstant.STANDARD_TOPUP_MONTHS,
                        StreamPlanConstant.TEN_DEVICE_TOPUP_PRICE)
        );
    }

    public static TopUpRepository getInstance() {
        if (instance == null)
            instance = new TopUpRepository();
        return instance;
    }

    public AbstractTopUp getToUp(String toUpType) {
        return topUps.stream()
                .filter(topUp -> topUp.getName().equals(toUpType))
                .findFirst()
                .orElse(null);
    }
}
