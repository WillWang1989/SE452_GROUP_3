package edu.depaul.se452.windycityflyers.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Data
@Document(collection = "runner_reviews")
@NoArgsConstructor
@AllArgsConstructor
public class RunnerReview{
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String review;
    private String reviewcomment;

}