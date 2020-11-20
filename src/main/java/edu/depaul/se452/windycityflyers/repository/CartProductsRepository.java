package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.CartProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductsRepository extends JpaRepository<CartProducts,Long> {
}
