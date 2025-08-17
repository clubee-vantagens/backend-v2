package com.clubee.infra.controller.customer;

import com.clubee.app.dto.CustomerAssignCategories;
import com.clubee.app.dto.CustomerRegister;
import com.clubee.app.usecase.customer.CustomerAssignCategoriesUseCase;
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
    private final CustomerRegisterUseCase customerRegisterUseCase;
    private final CustomerAssignCategoriesUseCase customerAssignCategoriesUseCase;

    public CustomerController(CustomerRegisterUseCase customerRegisterUseCase, CustomerAssignCategoriesUseCase customerAssignCategoriesUseCase) {
        this.customerRegisterUseCase = customerRegisterUseCase;
        this.customerAssignCategoriesUseCase = customerAssignCategoriesUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody CustomerRegister.Request request) {
        this.customerRegisterUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> assignCategories(@RequestBody CustomerAssignCategories.Request request) {
        this.customerAssignCategoriesUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
