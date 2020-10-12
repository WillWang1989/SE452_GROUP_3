package edu.depaul.se452.windycityflyers.repository;

import org.springframework.data.repository.CrudRepository;
import edu.depaul.se452.windycityflyers.model.*;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
