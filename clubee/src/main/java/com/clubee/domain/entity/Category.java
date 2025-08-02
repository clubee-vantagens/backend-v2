package com.clubee.domain.entity;

import com.clubee.domain.enums.CategoryType;

import java.util.List;

public class Category {
    private Long id;
    private CategoryType name;
    private List<Customer> customerEntities;

    public Category() {
    }

    public Category(Long id, CategoryType name, List<Customer> customerEntities) {
        this.id = id;
        this.name = name;
        this.customerEntities = customerEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customerEntities;
    }

    public void setCustomers(List<Customer> customerEntities) {
        this.customerEntities = customerEntities;
    }
}
