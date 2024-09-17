package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;

import java.util.List;

public class PodcastStream extends AbstractStream {
    public PodcastStream(List<AbstractPlan> plans) {
        super(plans);
        name = "PODCAST";
    }
}