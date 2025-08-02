package com.clubee.app.controller.customer;

import com.clubee.app.dto.request.CustomerRequestDto;
import com.clubee.app.dto.response.CustomerResponseDto;
import com.clubee.app.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/users/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponseDto> register(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        CustomerResponseDto response = this.customerService.register(customerRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
