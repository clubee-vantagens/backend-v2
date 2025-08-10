package com.clubee.infra.controller.customer;

import com.clubee.app.dto.ListCategories;
import com.clubee.app.usecase.customer.ListCategoriesUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/categories")
public class CategoriesController {
  private final ListCategoriesUseCase usecase;

  public CategoriesController(ListCategoriesUseCase usecase) {
    this.usecase = usecase;
  }

  @GetMapping
  public ResponseEntity<ListCategories.Response> listCategories() {
    ListCategories.Response response = this.usecase.execute();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
