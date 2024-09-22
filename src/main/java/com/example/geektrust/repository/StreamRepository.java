package com.example.geektrust.repository;

import com.example.geektrust.model.plans.AbstractPlan;
import com.example.geektrust.model.streams.AbstractStream;
import com.example.geektrust.model.streams.MusicStream;
import com.example.geektrust.model.streams.PodcastStream;
import com.example.geektrust.model.streams.VideoStream;

import java.util.Arrays;
import java.util.List;

public class StreamRepository {
    private static StreamRepository instance;
    private final List<AbstractStream> streams;

    private StreamRepository() {
        MusicStream musicStream = new MusicStream();
        VideoStream videoStream = new VideoStream();
        PodcastStream podcastStream = new PodcastStream();
        streams = Arrays.asList(musicStream, videoStream, podcastStream);
    }

    public static StreamRepository getInstance() {
        if (instance == null)
            instance = new StreamRepository();
        return instance;
    }

    public AbstractStream getStream(String streamType) {
        return streams.stream()
                .filter(stream -> stream.getName().equals(streamType))
                .findFirst().orElse(null);
    }

    public AbstractPlan getPlan(AbstractStream stream, String planType) {
        return stream.getPlans().stream()
                .filter(plan -> plan.getName().equals(planType))
                .findFirst()
                .orElse(null);
    }
}
