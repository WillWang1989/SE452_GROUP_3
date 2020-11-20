package edu.depaul.se452.windycityflyers.service;
import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
public interface CustomerService  {

    Customer findByEmail(String email);
    Customer findByUsername(String username);
    Customer save(CustomerRegistrationDto registration);
}