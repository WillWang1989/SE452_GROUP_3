package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.CartProducts;

import java.util.List;

public interface CartProductsService {
    List<CartProducts> findAll();
    CartProducts update(CartProducts cp);

    CartProducts findById(Long id);

    void deleteById(Long id);
}
