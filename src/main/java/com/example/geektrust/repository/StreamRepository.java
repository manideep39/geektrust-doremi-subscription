package com.example.geektrust.repository;

import com.example.geektrust.model.plans.AbstractPlan;
import com.example.geektrust.model.plans.FreePlan;
import com.example.geektrust.model.plans.PersonalPlan;
import com.example.geektrust.model.plans.PremiumPlan;
import com.example.geektrust.model.streams.AbstractStream;
import com.example.geektrust.model.streams.MusicStream;
import com.example.geektrust.model.streams.PodcastStream;
import com.example.geektrust.model.streams.VideoStream;

import java.util.Arrays;
import java.util.List;

public class StreamRepository {
    private final List<AbstractStream> streams;

    public StreamRepository() {
        MusicStream musicStream = new MusicStream(
                Arrays.asList(
                        new FreePlan(RepositoryConstants.FREE_PLAN_MONTHS,
                                RepositoryConstants.MUSIC_FREE_PLAN_PRICE),
                        new PersonalPlan(RepositoryConstants.PERSONAL_PLAN_MONTHS,
                                RepositoryConstants.MUSIC_PERSONAL_PLAN_PRICE),
                        new PremiumPlan(RepositoryConstants.PREMIUM_PLAN_MONTHS,
                                RepositoryConstants.MUSIC_PREMIUM_PLAN_PRICE)
                )
        );

        VideoStream videoStream = new VideoStream(
                Arrays.asList(
                        new FreePlan(RepositoryConstants.FREE_PLAN_MONTHS,
                                RepositoryConstants.VIDEO_FREE_PLAN_PRICE),
                        new PersonalPlan(RepositoryConstants.PERSONAL_PLAN_MONTHS,
                                RepositoryConstants.VIDEO_PERSONAL_PLAN_PRICE),
                        new PremiumPlan(RepositoryConstants.PREMIUM_PLAN_MONTHS,
                                RepositoryConstants.VIDEO_PREMIUM_PLAN_PRICE)
                )
        );

        PodcastStream podcastStream = new PodcastStream(
                Arrays.asList(
                        new FreePlan(RepositoryConstants.FREE_PLAN_MONTHS,
                                RepositoryConstants.PODCAST_FREE_PLAN_PRICE),
                        new PersonalPlan(RepositoryConstants.PERSONAL_PLAN_MONTHS,
                                RepositoryConstants.PODCAST_PERSONAL_PLAN_PRICE),
                        new PremiumPlan(RepositoryConstants.PREMIUM_PLAN_MONTHS,
                                RepositoryConstants.PODCAST_PREMIUM_PLAN_PRICE)
                )
        );

        streams = Arrays.asList(musicStream, videoStream, podcastStream);
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
