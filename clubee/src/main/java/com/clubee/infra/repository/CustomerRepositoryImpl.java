package com.clubee.infra.repository;

import com.clubee.app.mapper.CustomerMapper;
import com.clubee.app.repository.CustomerRepository;
import com.clubee.domain.entity.Customer;
import com.clubee.infra.database.CustomerJPARepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerJPARepository repository;
    private final CustomerMapper mapper;

    public CustomerRepositoryImpl(CustomerJPARepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(Customer customer) {
        repository.save(mapper.toModel(customer));
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toEntity);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id).map(mapper::toEntity);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll().stream()
                .map(mapper::toEntity)
                .toList();
    }

    @Override
    public boolean existsByUserEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }
}
