package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.ShoppingCart;


public interface ShoppingCartService {

    ShoppingCart update(ShoppingCart sc);

    ShoppingCart findById(String id);

    ShoppingCart findByCustomerId(Long id);
    ShoppingCart findByCustomerUsername(String un);

    void deleteById(String id);
}
