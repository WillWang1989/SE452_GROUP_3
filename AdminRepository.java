package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Customer, Long> {
}
