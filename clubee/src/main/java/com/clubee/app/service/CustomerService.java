package com.clubee.app.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRegisterUseCase customerRegisterUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;


    public CustomerService(CustomerRegisterUseCase customerRegisterUseCase,
                           GetAllCustomersUseCase getAllCustomersUseCase,
                           GetCustomerByIdUseCase getCustomerByIdUseCase) {
        this.customerRegisterUseCase = customerRegisterUseCase;
        this.getAllCustomersUseCase = getAllCustomersUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    public CustomerResponseDto register(CustomerRequestDto request) {
        return this.customerRegisterUseCase.execute(request);
    }

    public List<CustomerResponseDto> getAllCustomers() {
        return this.getAllCustomersUseCase.execute();
    }

    public CustomerResponseDto getCustomerById(String id) {
        return this.getCustomerByIdUseCase.execute(id);
    }
}
