package edu.depaul.se452.windycityflyers.service;


import edu.depaul.se452.windycityflyers.model.Store;
import edu.depaul.se452.windycityflyers.repository.CustomerRepository;
import edu.depaul.se452.windycityflyers.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Override
    public List<Store> findAll() {
        return  storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store findById(String id) {
        return storeRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public void deleteById(String id) {
        storeRepository.deleteById(Long.parseLong(id));
    }
}
