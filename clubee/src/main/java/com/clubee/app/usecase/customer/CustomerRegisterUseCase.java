package com.clubee.app.usecase.customer;

import com.clubee.app.dto.CustomerRegister;
import com.clubee.domain.entity.Customer;
import com.clubee.domain.vo.CPF;
import com.clubee.domain.vo.Email;
import com.clubee.domain.vo.Name;
import com.clubee.domain.vo.Password;
import com.clubee.infra.exception.general.UniqueValueInUseException;
import com.clubee.infra.exception.general.UnmatchedPasswordException;
import com.clubee.infra.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegisterUseCase {

    private final CustomerRepository customerRepository;

    public CustomerRegisterUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(CustomerRegister.Request request) {
        Email email = new Email();
        email.setEmail(request.email());

        CPF cpf = new CPF();
        cpf.setCPF(request.cpf());

        if (customerRepository.existsByEmail(email) || customerRepository.existsByCpf(cpf)) {
            throw new UniqueValueInUseException("Registration failed! Please check the data and try again.");
        }
        if (!request.password().equals(request.passwordConfirmation())) {
            throw new UnmatchedPasswordException("The passwords does not match");
        }

        Name name = new Name();
        name.setName(request.name());

        Name socialName = new Name();

        if(!request.socialName().isEmpty()) {
            socialName.setName(request.socialName());
        }

        Password password = new Password();
        password.setPassword(request.password());

        Customer customer = new Customer();
        customer.setName(name);
        customer.setSocialName(socialName);
        customer.setEmail(email);
        customer.setCpf(cpf);
        customer.setPassword(password);

        this.customerRepository.save(customer);
    }
}
