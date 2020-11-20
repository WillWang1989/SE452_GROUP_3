package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.CartProducts;
import edu.depaul.se452.windycityflyers.repository.CartProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductsServiceImpl implements CartProductsService {
    @Autowired
    private CartProductsRepository cartProductsRepository;
    @Override
    public List<CartProducts> findAll() {
        return cartProductsRepository.findAll();
    }

    @Override
    public CartProducts update(CartProducts cp) {
        return cartProductsRepository.save(cp);
    }

    @Override
    public CartProducts findById(Long id) {
        return cartProductsRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        cartProductsRepository.deleteById(id);
    }
}
