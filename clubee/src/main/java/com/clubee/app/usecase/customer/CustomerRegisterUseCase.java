package com.clubee.app.usecase.customer;

import com.clubee.app.dto.request.CustomerRequestDto;
import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.app.mapper.CustomerMapper;
import com.clubee.app.repository.CustomerRepository;
import com.clubee.domain.entity.Customer;
import com.clubee.infra.exception.general.UniqueValueInUseException;
import com.clubee.infra.exception.general.UnmatchedPasswordException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegisterUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public CustomerRegisterUseCase(CustomerRepository customerRepository, CustomerMapper mapper, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public CustomerResponseDto execute(CustomerRequestDto request) {

        if (customerRepository.existsByUserEmail(request.email()) || customerRepository.existsByCpf(request.cpf())) {
            throw new UniqueValueInUseException("Registration failed! Please check the data and try again.");
        }

        if (!request.password().equals(request.passwordConfirmation())) {
            throw new UnmatchedPasswordException("The passwords does not match");
        }

        Customer customer = mapper.toEntity(request);
        var user = new User(
                request.email(),
                passwordEncoder.encode(request.password()),
                Role.CUSTOMER,
                true
        );
        customer.setUser(user);

        this.customerRepository.save(customer);

        return mapper.toDto(customer);
    }
}
