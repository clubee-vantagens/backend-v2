package com.clubee.infra.controller.customer;

import com.clubee.app.dto.CustomerRegister;
import com.clubee.app.usecase.customer.CustomerRegisterUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/customers")
public class CustomerController {
    private final CustomerRegisterUseCase usecase;

    public CustomerController(CustomerRegisterUseCase usecase) {
        this.usecase = usecase;
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody CustomerRegister.Request request) {
        this.usecase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
