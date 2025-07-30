package com.clubee.app.repository;

import com.clubee.domain.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    void save(Customer customer);
    Optional<Customer> findByEmail(String email);
    boolean existsByUserEmail(String email);
    boolean existsByCpf(String cpf);
    List<Customer> findAllCustomers();
    Optional<Customer> findById(UUID id);
}
