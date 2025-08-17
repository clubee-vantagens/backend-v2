package com.clubee.app.usecase.customer;

import com.clubee.app.dto.CustomerAssignCategories;
import com.clubee.domain.entity.Customer;
import com.clubee.domain.enums.Categories;
import com.clubee.infra.exception.general.EntityNotFoundException;
import com.clubee.infra.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Set;

@Service
public class CustomerAssignCategoriesUseCase {
  private final CustomerRepository customerRepository;

  public CustomerAssignCategoriesUseCase(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void execute(CustomerAssignCategories.Request request) {
    Customer customer = this.customerRepository.findById(request.customerId()).orElseThrow(() -> new EntityNotFoundException("Customer not found"));

    Set<Categories> categories = null;

    System.out.println(request.categories());

    if(request.categories() == null || request.categories().isEmpty()) {
      categories = EnumSet.allOf(Categories.class);
    } else if(request.categories().size() < 3){
      throw new IllegalArgumentException("A minimum of 3 categories must be selected");
    } else {
      categories = request.categories();
    }

    customer.setCategories(categories);
    this.customerRepository.save(customer);
  }

}
