package com.clubee.app.dto;

import com.clubee.domain.enums.Categories;

import java.util.Set;
import java.util.UUID;

public class CustomerAssignCategories {
  public record Request(UUID customerId, Set<Categories> categories) {}
}
