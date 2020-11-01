package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.dto.CustomerRegistrationDto;
import edu.depaul.se452.windycityflyers.model.Department;
import edu.depaul.se452.windycityflyers.model.Payment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public Payment findById(String cust_id) {
        return null;
    }

    @Override
    public Payment save(CustomerRegistrationDto registration) {
        return null;
    }
}
