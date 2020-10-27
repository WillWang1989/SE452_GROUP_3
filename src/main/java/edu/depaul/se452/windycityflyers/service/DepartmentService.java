package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();
    Department update(Department student);

    Department findById(String studentId);

    void deleteById(String studentId);
}
