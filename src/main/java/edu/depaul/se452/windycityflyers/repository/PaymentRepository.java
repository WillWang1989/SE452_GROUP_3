package edu.depaul.se452.windycityflyers.repository;

import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
