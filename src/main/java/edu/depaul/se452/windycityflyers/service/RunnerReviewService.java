package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.RunnerReview;

import java.util.List;

public interface RunnerReviewService {
    List<RunnerReview> findAll();

    RunnerReview update(RunnerReview runner_reviews);
    RunnerReview findById(String id);
    void deleteById(String id);
}


