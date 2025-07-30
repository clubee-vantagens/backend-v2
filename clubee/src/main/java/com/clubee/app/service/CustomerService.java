package com.clubee.app.service;

import com.clubee.app.usecase.customer.FindAllCustomersUseCase;
import com.clubee.app.usecase.customer.RegisterCustomerUseCase;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final FindAllCustomersUseCase findAllCustomersUseCase;

    public CustomerService(RegisterCustomerUseCase registerCustomerUseCase, FindAllCustomersUseCase findAllCustomersUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.findAllCustomersUseCase = findAllCustomersUseCase;
    }
}
