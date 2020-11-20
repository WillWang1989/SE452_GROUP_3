package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
    ShoppingCart findByCustomerId(Long id);
    ShoppingCart findByCustomerUsername(String un);
}
