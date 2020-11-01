package edu.depaul.se452.windycityflyers.service;
import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.model.Payment;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    Payment findById(String cust_id);
    Payment save(CustomerRegistrationDto registration);
}