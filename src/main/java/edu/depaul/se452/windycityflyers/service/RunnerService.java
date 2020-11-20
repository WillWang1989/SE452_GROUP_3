package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.model.Runner;

public interface RunnerService {
    Runner findByName(String name);
}
