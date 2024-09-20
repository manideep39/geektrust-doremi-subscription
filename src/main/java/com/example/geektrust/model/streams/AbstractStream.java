package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;

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

    public void setPlans(List<AbstractPlan> plans) {
        this.plans = plans;
    }

    public String getName() {
        return name;
    }

    protected abstract List<AbstractPlan> createPlans();
}
