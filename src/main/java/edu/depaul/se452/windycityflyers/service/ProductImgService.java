package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.ProductImg;

import java.util.List;

public interface ProductImgService {
    List<ProductImg> findAll();
    ProductImg update(ProductImg img);
    ProductImg findById(String id);
    void deleteById(String id);
}
