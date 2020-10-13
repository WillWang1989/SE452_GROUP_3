package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Logs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogsRepository extends MongoRepository<Logs, String> {

}