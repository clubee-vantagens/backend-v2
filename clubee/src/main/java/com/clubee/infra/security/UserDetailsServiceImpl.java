package com.clubee.infra.security;

import com.clubee.app.repository.CustomerRepository;
import com.clubee.domain.entity.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("Invalid email.");
        }

        return (UserDetails) customer.get().getUser();
    }
}
