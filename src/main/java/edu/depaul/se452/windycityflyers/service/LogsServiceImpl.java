package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Logs;
import edu.depaul.se452.windycityflyers.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsRepository logsRepository;
    @Override
    public List<Logs> findAll() {
        return logsRepository.findAll();
    }

    @Override
    public Page<Logs> findAll(Pageable pageable) {
        return  logsRepository.findAll(pageable);
    }

    @Override
    public Page<Logs> findInAllFields(String q, Pageable pageable) {
        return logsRepository.findInAllFields(q,pageable);
    }

    @Override
    public Logs update(Logs log) {
        return logsRepository.save(log);
    }

    @Override
    public Logs findById(String id) {
        return logsRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        logsRepository.deleteById(id);
    }
}
