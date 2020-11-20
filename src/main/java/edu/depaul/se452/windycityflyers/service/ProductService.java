package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product update(Product product);
    Product findById(String id);
    void deleteById(String id);
    Page<Product>  findInAllFields(Long storeId,String q, Pageable pageable);
}
