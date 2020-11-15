package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.RunnerReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunnerReviewRepository extends MongoRepository <RunnerReview, String> {
}
