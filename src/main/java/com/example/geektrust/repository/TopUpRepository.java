package com.example.geektrust.repository;

import com.example.geektrust.model.topups.AbstractTopUp;
import com.example.geektrust.model.topups.FourDeviceTopUp;
import com.example.geektrust.model.topups.TenDeviceTopUp;

import java.util.Arrays;
import java.util.List;

public class TopUpRepository {
    private static TopUpRepository instance;
    private final List<AbstractTopUp> topUps;

    private TopUpRepository() {
        topUps = Arrays.asList(
                new FourDeviceTopUp(RepositoryConstants.STANDARD_TOPUP_MONTHS,
                        RepositoryConstants.FOUR_DEVICE_TOPUP_PRICE),
                new TenDeviceTopUp(RepositoryConstants.STANDARD_TOPUP_MONTHS,
                        RepositoryConstants.TEN_DEVICE_TOPUP_PRICE)
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
