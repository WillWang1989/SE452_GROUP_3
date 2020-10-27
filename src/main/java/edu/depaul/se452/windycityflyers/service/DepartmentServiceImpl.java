package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department update(Department student) {
        return null;
    }

    @Override
    public Department findById(String studentId) {
        return null;
    }

    @Override
    public void deleteById(String studentId) {

    }
}
