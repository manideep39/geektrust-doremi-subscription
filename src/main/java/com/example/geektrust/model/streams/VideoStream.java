package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;

import java.util.List;

public class VideoStream extends AbstractStream {
    public VideoStream(List<AbstractPlan> plans) {
        super(plans);
        name = "VIDEO";
    }
}