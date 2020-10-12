package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
