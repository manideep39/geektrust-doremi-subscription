package com.example.geektrust.model.stream;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.model.Plan;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class MusicStream extends AbstractStream {
    public MusicStream() {
        name = "MUSIC";
    }

    @Override
    protected List<Plan> createPlans() {
        return Arrays.asList(
                new Plan(PlanType.FREE, StreamPlanConstant.MUSIC_FREE_PLAN_PRICE),
                new Plan(PlanType.PERSONAL, StreamPlanConstant.MUSIC_PERSONAL_PLAN_PRICE),
                new Plan(PlanType.PREMIUM, StreamPlanConstant.MUSIC_PREMIUM_PLAN_PRICE)
        );
    }
}
