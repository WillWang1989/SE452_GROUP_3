package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Department;
import edu.depaul.se452.windycityflyers.repository.DepartmentRepository;
import edu.depaul.se452.windycityflyers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    private DepartmentRepository productRepository;
    @Override
    public List<Department> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Department update(Department item) {
        return productRepository.save(item);
    }

    @Override
    public Department findById(String id) {
        return productRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(Long.parseLong(id));
    }
}
