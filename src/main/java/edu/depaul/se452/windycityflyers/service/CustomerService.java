package edu.depaul.se452.windycityflyers.service;
import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface CustomerService extends UserDetailsService {

    Customer findByEmail(String email);

    Customer save(CustomerRegistrationDto registration);
}