package com.example.geektrust.model.stream;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.constant.StreamType;
import com.example.geektrust.model.Plan;

import java.util.List;

public abstract class AbstractStream {
    private final List<Plan> plans;
    private final StreamType streamType;

    protected AbstractStream(StreamType streamType) {
        this.plans = createPlans();
        this.streamType = streamType;
    }

    public StreamType getStreamType() {
        return streamType;
    }

    public Plan getPlan(PlanType planType) {
        return plans.stream()
                .filter(plan -> plan.getPlanType().equals(planType))
                .findFirst().orElse(null);
    }

    protected abstract List<Plan> createPlans();
}
