package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.model.ProductImg;

import java.util.List;

public interface LogsService {
    List<Logs> findAll();
    Logs update(Logs log);
    Logs findById(String id);
    void deleteById(String id);
}
