package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.ShoppingCart;

import edu.depaul.se452.windycityflyers.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart update(ShoppingCart sc) {
        return shoppingCartRepository.save(sc);
    }

    @Override
    public ShoppingCart findById(String id) {
        return shoppingCartRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public ShoppingCart findByCustomerId(Long id) {
        return shoppingCartRepository.findByCustomerId(id);
    }

    @Override
    public ShoppingCart findByCustomerUsername(String un) {
        return shoppingCartRepository.findByCustomerUsername(un);
    }

    @Override
    public void deleteById(String id) {
        shoppingCartRepository.deleteById(Long.parseLong(id));
    }
}
