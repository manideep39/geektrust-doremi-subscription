package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;
import com.example.geektrust.model.plans.FreePlan;
import com.example.geektrust.model.plans.PersonalPlan;
import com.example.geektrust.model.plans.PremiumPlan;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class PodcastStream extends AbstractStream {
    public PodcastStream() {
        name = "PODCAST";
    }

    @Override
    protected List<AbstractPlan> createPlans() {
        return Arrays.asList(
                new FreePlan(StreamPlanConstant.FREE_PLAN_MONTHS,
                        StreamPlanConstant.VIDEO_FREE_PLAN_PRICE),
                new PersonalPlan(StreamPlanConstant.PERSONAL_PLAN_MONTHS,
                        StreamPlanConstant.VIDEO_PERSONAL_PLAN_PRICE),
                new PremiumPlan(StreamPlanConstant.PREMIUM_PLAN_MONTHS,
                        StreamPlanConstant.VIDEO_PREMIUM_PLAN_PRICE)
        );
    }
}