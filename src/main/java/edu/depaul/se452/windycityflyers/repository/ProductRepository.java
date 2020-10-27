package edu.depaul.se452.windycityflyers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.depaul.se452.windycityflyers.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
