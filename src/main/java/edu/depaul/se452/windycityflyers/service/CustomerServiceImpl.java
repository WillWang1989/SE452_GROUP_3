package edu.depaul.se452.windycityflyers.service;


import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Customer findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Customer findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Customer save(CustomerRegistrationDto registration) {
        Customer user = new Customer();
        user.setFirstname(registration.getFirstName());
        user.setLastname(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setUsername(registration.getUserName());
        return userRepository.save(user);
    }
}
