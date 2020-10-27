package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Store;

import java.util.List;

public interface StoreService {
    public List<Store> findAll();
    public Store update(Store store);

    public Store findById(String id);


    public void deleteById(String id);
}
