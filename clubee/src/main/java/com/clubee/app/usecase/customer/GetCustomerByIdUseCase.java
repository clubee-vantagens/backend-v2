package com.clubee.app.usecase.customer;

import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.app.mapper.CustomerMapper;
import com.clubee.app.repository.CustomerRepository;
import com.clubee.domain.entity.Customer;
import com.clubee.infra.exception.general.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class GetCustomerByIdUseCase {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdUseCase(CustomerRepository customerRepository, CustomerMapper mapper) {
        this.customerRepository = customerRepository;

    }

    public CustomerResponseDto execute(String id) {
        Optional<Customer> customer = customerRepository.findById(UUID.fromString(id));

        if (customer.isEmpty()) {
            throw new EntityNotFoundException("Customer not found");
        }

        return new CustomerResponseDto(
                customer.get().getId(),
                customer.get().getName(),
                customer.get().getSocialName(),
                customer.get().getEmail(),
                customer.get().getCpf());
    }
}
