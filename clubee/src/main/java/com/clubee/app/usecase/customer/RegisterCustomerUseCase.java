package com.clubee.app.usecase.customer;

import com.clubee.app.dto.request.CustomerRequestDto;
import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.app.mapper.CustomerMapper;
import com.clubee.app.repository.CustomerRepository;
import com.clubee.domain.entity.Customer;
import com.clubee.domain.entity.User;
import com.clubee.domain.enums.Role;
import com.clubee.infra.exception.general.DuplicateDataException;
import com.clubee.infra.exception.general.UnmatchedPasswordException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerUseCase {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public RegisterCustomerUseCase(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public CustomerResponseDto execute(CustomerRequestDto request) {
        if (!request.password().equals(request.passwordConfirmation())) {
            throw new UnmatchedPasswordException("As senhas não coincidem");
        }

        Customer customer = mapper.toEntity(request);
        User user = new User(request.email(), request.password());
        customer.setUser(user);

        this.repository.save(customer);

        return mapper.toDto(customer);
    }
}
