package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.ProductImg;
import edu.depaul.se452.windycityflyers.repository.ProductImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    private ProductImgRepository productImgRepository;
    @Override
    public List<ProductImg> findAll() {
        return productImgRepository.findAll();
    }

    @Override
    public ProductImg update(ProductImg img) {
        return productImgRepository.save(img);
    }

    @Override
    public ProductImg findById(String id) {
        return productImgRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public void deleteById(String id) {
        productImgRepository.deleteById(Long.parseLong(id));
    }
}
