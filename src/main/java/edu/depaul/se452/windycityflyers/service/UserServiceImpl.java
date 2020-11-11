package edu.depaul.se452.windycityflyers.service;

import edu.depaul.se452.windycityflyers.model.Admin;
import edu.depaul.se452.windycityflyers.model.Customer;
import edu.depaul.se452.windycityflyers.model.Runner;
import edu.depaul.se452.windycityflyers.repository.AdminRepository;
import edu.depaul.se452.windycityflyers.repository.CustomerRepository;
import edu.depaul.se452.windycityflyers.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerRepository userRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = userRepository.findByEmail(email);
        if (user == null) {
            user = userRepository.findByUsername(email);
        }
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_CUSTOMER")));

        }
        Runner runner = runnerRepository.findByName(email);
        if(runner!=null){
            return new org.springframework.security.core.userdetails.User(runner.getName(),
                    runner.getPassword(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_RUNNER")));
        }
        Admin admin = adminRepository.findByUsername(email);
        if(admin!=null){
            return new org.springframework.security.core.userdetails.User(admin.getUser_name(),
                    admin.getPassword(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        throw new UsernameNotFoundException("Invalid username or password.");

    }
}
