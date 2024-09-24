package com.example.geektrust.model.stream;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.model.Plan;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class PodcastStream extends AbstractStream {
    public PodcastStream() {
        name = "PODCAST";
    }

    @Override
    protected List<Plan> createPlans() {
        return Arrays.asList(
                new Plan(PlanType.FREE, StreamPlanConstant.PODCAST_FREE_PLAN_PRICE),
                new Plan(PlanType.PERSONAL, StreamPlanConstant.PODCAST_PERSONAL_PLAN_PRICE),
                new Plan(PlanType.PREMIUM, StreamPlanConstant.PODCAST_PREMIUM_PLAN_PRICE)
        );
    }
}