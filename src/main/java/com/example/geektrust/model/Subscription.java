package com.example.geektrust.model;

import com.example.geektrust.model.plan.AbstractPlan;
import com.example.geektrust.model.stream.AbstractStream;

import java.time.LocalDate;

public class Subscription {
    private final LocalDate startDate;
    private final AbstractStream stream;
    private final AbstractPlan plan;

    public Subscription(LocalDate startDate, AbstractStream stream, AbstractPlan plan) {
        this.startDate = startDate;
        this.stream = stream;
        this.plan  = plan;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public AbstractStream getStream() {
        return stream;
    }

    public AbstractPlan getPlan() {
        return plan;
    }
}
