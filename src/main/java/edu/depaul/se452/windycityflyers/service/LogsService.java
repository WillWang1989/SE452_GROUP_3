package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.model.ProductImg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;

import java.util.List;

public interface LogsService {
    List<Logs> findAll();
    Page<Logs> findAll(Pageable pageable);
    Page<Logs> findInAllFields(String q, Pageable pageable);

    Logs update(Logs log);
    Logs findById(String id);
    void deleteById(String id);
}
