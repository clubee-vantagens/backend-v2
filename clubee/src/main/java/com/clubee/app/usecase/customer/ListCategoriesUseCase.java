package com.clubee.app.usecase.customer;

import com.clubee.app.dto.ListCategories;
import com.clubee.domain.enums.Categories;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ListCategoriesUseCase {

  public ListCategories.Response execute() {
    String[] categories = Arrays.stream(Categories.values())
            .map(Categories::getCategory)
            .toArray(String[]::new);

    return new ListCategories.Response(categories);
  }
}
