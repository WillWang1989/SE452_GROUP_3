package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Runner;
import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner,Long> {
    Runner findByName(String name);
}
