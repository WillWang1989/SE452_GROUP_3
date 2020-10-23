package edu.depaul.se452.windycityflyers.service;


import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Customer findByEmail(String email) {
        return userRepository.findByEmail(email);
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = userRepository.findByEmail(email);
        if (user == null) {
            user = userRepository.findByUsername(email);
            if(user ==null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
