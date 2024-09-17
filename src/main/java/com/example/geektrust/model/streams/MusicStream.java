package com.example.geektrust.model.streams;

import com.example.geektrust.model.plans.AbstractPlan;

import java.util.List;

public class MusicStream extends AbstractStream {
    public MusicStream(List<AbstractPlan> plans) {
        super(plans);
        name = "MUSIC";
    }
}
