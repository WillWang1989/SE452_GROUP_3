package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Runner;
import edu.depaul.se452.windycityflyers.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnerServiceImpl implements RunnerService {
    @Autowired
    private RunnerRepository runnerRepository;
    @Override
    public Runner findByName(String name) {
        return runnerRepository.findByName(name);
    }
}
