package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByUsername(String username);
}
