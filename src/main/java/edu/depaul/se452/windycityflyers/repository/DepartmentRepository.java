package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Long> {
}
