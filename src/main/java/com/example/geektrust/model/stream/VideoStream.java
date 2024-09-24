package com.example.geektrust.model.stream;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.constant.StreamType;
import com.example.geektrust.model.Plan;
import com.example.geektrust.constant.StreamPlanConstant;

import java.util.Arrays;
import java.util.List;

public class VideoStream extends AbstractStream {
    public VideoStream() {
        super(StreamType.VIDEO);
    }

    @Override
    protected List<Plan> createPlans() {
        return Arrays.asList(
                new Plan(PlanType.FREE, StreamPlanConstant.VIDEO_FREE_PLAN_PRICE),
                new Plan(PlanType.PERSONAL, StreamPlanConstant.VIDEO_PERSONAL_PLAN_PRICE),
                new Plan(PlanType.PREMIUM, StreamPlanConstant.VIDEO_PREMIUM_PLAN_PRICE)
        );
    }
}