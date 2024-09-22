package com.example.geektrust.model.stream;

import com.example.geektrust.model.plan.AbstractPlan;

import java.util.List;

public abstract class AbstractStream {
    protected List<AbstractPlan> plans;
    protected String name;

    protected AbstractStream() {
        this.plans = createPlans();
    }

    public List<AbstractPlan> getPlans() {
        return plans;
    }

    public String getName() {
        return name;
    }

    protected abstract List<AbstractPlan> createPlans();
}
