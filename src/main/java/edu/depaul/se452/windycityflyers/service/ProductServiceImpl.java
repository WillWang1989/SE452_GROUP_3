package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Product;
import edu.depaul.se452.windycityflyers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return  productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Page<Product> findInAllFields(Long storeId, String q, Pageable pageable) {
        return productRepository.findInAllFields(storeId,q,pageable);
    }


}
