package com.clubee.app.mapper;

import com.clubee.app.dto.request.CustomerRequestDto;
import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.domain.entity.Address;
import com.clubee.domain.entity.Category;
import com.clubee.domain.entity.Customer;
import com.clubee.domain.entity.User;
import com.clubee.infra.database.model.AddressModel;
import com.clubee.infra.database.model.CategoryModel;
import com.clubee.infra.database.model.CustomerModel;
import com.clubee.infra.database.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final PasswordEncoder passwordEncoder;

    public CustomerMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerModel toModel(Customer customer) {
        UserModel userModel = new UserModel(
                customer.getUser().getEmail(),
                passwordEncoder.encode(customer.getUser().getPassword())
        );
        userModel.setActive(customer.getUser().getActive());
        userModel.setRole(customer.getUser().getRole());

        AddressModel addressModel = null;
        if (customer.getAddress() != null) {
            Address address = customer.getAddress();
            addressModel = new AddressModel(
                    address.getCep(), address.getStreet(), address.getDistrict(), address.getCity(),
                    address.getAddressNumber(), address.getComplement(), address.getContactPhone(), address.getStates()
            );
        }

        CustomerModel model = new CustomerModel(
                customer.getName(),
                customer.getSocialName(),
                customer.getCpf(),
                customer.getEmail(),
                Optional.ofNullable(customer.getPhoneNumber()).orElse(null),
                Optional.ofNullable(customer.getDateOfBirth()).orElse(null),
                addressModel,
                customer.getPreferences() != null ? customer.getPreferences().stream()
                        .map(preference -> new CategoryModel(preference.getId(), preference.getName()))
                        .collect(Collectors.toSet()) : Collections.emptySet()
        );

        model.setId(customer.getId());
        model.setUser(userModel);

        return model;
    }

    public Customer toEntity(CustomerModel model) {
        AddressModel addressModel = model.getAddress();
        Address address = new Address(addressModel.getCep(), addressModel.getStreet(), addressModel.getDistrict(), addressModel.getCity(),
                addressModel.getAddressNumber(), addressModel.getComplement(), addressModel.getContactPhone(), addressModel.getStates());

        UserModel userModel = model.getUser();
        User user = new User(userModel.getEmail(), userModel.getPassword());
        user.setId(userModel.getId());
        user.setActive(userModel.getActive());
        user.setRole(userModel.getRole());

        Customer customer = new Customer(
                model.getId(),
                model.getName(),
                model.getSocialName(),
                model.getEmail(),
                model.getCpf(),
                model.getPhoneNumber(),
                model.getDateOfBirth(),
                address,
                model.getPreferences().stream()
                        .map(categoryModel -> new Category(categoryModel.getId(), categoryModel.getName(), null))
                        .collect(Collectors.toSet())
        );
        customer.setUser(user);

        return customer;
    }

    public Customer toEntity(CustomerRequestDto request) {
        Customer customer = new Customer(
                null,
                request.name(),
                request.socialName(),
                request.email(),
                request.cpf(),
                null,
                null,
                null,
                null
        );

        return customer;
    }

    public CustomerResponseDto toDto(Customer customer) {
        CustomerResponseDto response = new CustomerResponseDto(
                customer.getId(),
                customer.getName(),
                customer.getSocialName(),
                customer.getEmail(),
                customer.getCpf()
        );

        return response;
    }
}
