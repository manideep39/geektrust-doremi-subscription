package com.example.geektrust.repository;

import com.example.geektrust.model.topups.AbstractTopUp;
import com.example.geektrust.model.topups.FourDeviceTopUp;
import com.example.geektrust.model.topups.TenDeviceTopUp;

import java.util.Arrays;
import java.util.List;

public class TopUpRepository {
    private final List<AbstractTopUp> topUps;

    public TopUpRepository() {
        topUps = Arrays.asList(
                new FourDeviceTopUp(RepositoryConstants.STANDARD_TOPUP_MONTHS,
                        RepositoryConstants.FOUR_DEVICE_TOPUP_PRICE),
                new TenDeviceTopUp(RepositoryConstants.STANDARD_TOPUP_MONTHS,
                        RepositoryConstants.TEN_DEVICE_TOPUP_PRICE)
        );
    }

    public AbstractTopUp getToUp(String toUpType) {
        return topUps.stream()
                .filter(topUp -> topUp.getName().equals(toUpType))
                .findFirst()
                .orElse(null);
    }
}
