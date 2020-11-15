package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.model.RunnerReview;
import edu.depaul.se452.windycityflyers.repository.RunnerReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerReviewServiceImpl implements RunnerReviewService {
    @Autowired
    private RunnerReviewRepository runnerReviewRepository;

    @Override
    public List<RunnerReview> findAll() {
        return runnerReviewRepository.findAll();
    }

    @Override
    public RunnerReview update(RunnerReview runner_reviews) {
        return runnerReviewRepository.save(runner_reviews);
    }

    @Override
    public RunnerReview findById(String id) {
        return runnerReviewRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) { runnerReviewRepository.deleteById(id);
    }
}