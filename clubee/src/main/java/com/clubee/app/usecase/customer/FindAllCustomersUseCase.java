package com.clubee.app.usecase.customer;

import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.app.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCustomersUseCase {
    private final CustomerRepository customerRepository;

    public FindAllCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> execute() {
        return customerRepository.findAllCustomers()
                .stream()
                .map(customer -> new CustomerResponseDto(
                        customer.getId(),
                        customer.getName(),
                        customer.getSocialName(),
                        customer.getEmail(),
                        customer.getCpf()
                ))
                .toList();
    }
}
