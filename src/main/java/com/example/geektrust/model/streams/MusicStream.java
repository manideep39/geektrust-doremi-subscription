package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;
import com.example.geektrust.model.plans.FreePlan;
import com.example.geektrust.model.plans.PersonalPlan;
import com.example.geektrust.model.plans.PremiumPlan;
import com.example.geektrust.repository.RepositoryConstants;

import java.util.Arrays;
import java.util.List;

public class MusicStream extends AbstractStream {
    public MusicStream() {
        name = "MUSIC";
    }

    @Override
    protected List<AbstractPlan> createPlans() {
        return Arrays.asList(
                new FreePlan(RepositoryConstants.FREE_PLAN_MONTHS,
                        RepositoryConstants.MUSIC_FREE_PLAN_PRICE),
                new PersonalPlan(RepositoryConstants.PERSONAL_PLAN_MONTHS,
                        RepositoryConstants.MUSIC_PERSONAL_PLAN_PRICE),
                new PremiumPlan(RepositoryConstants.PREMIUM_PLAN_MONTHS,
                        RepositoryConstants.MUSIC_PREMIUM_PLAN_PRICE)
        );
    }
}
