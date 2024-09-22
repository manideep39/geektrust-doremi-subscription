package com.example.geektrust.model.stream;

import com.example.geektrust.model.plan.AbstractPlan;
import com.example.geektrust.model.plan.FreePlan;
import com.example.geektrust.model.plan.PersonalPlan;
import com.example.geektrust.model.plan.PremiumPlan;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class MusicStream extends AbstractStream {
    public MusicStream() {
        name = "MUSIC";
    }

    @Override
    protected List<AbstractPlan> createPlans() {
        return Arrays.asList(
                new FreePlan(StreamPlanConstant.FREE_PLAN_MONTHS,
                        StreamPlanConstant.MUSIC_FREE_PLAN_PRICE),
                new PersonalPlan(StreamPlanConstant.PERSONAL_PLAN_MONTHS,
                        StreamPlanConstant.MUSIC_PERSONAL_PLAN_PRICE),
                new PremiumPlan(StreamPlanConstant.PREMIUM_PLAN_MONTHS,
                        StreamPlanConstant.MUSIC_PREMIUM_PLAN_PRICE)
        );
    }
}
