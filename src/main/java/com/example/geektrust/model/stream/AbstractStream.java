package com.example.geektrust.model.stream;

import com.example.geektrust.constant.PlanType;
import com.example.geektrust.model.Plan;

import java.util.List;

public abstract class AbstractStream {
    protected List<Plan> plans;
    protected String name;

    protected AbstractStream() {
        this.plans = createPlans();
    }

    public String getName() {
        return name;
    }

    public Plan getPlan(PlanType planType) {
        return plans.stream()
                .filter(plan -> plan.getPlanType().equals(planType))
                .findFirst().orElse(null);
    }

    protected abstract List<Plan> createPlans();
}
