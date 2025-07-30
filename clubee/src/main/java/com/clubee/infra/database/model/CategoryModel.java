package com.clubee.infra.database.model;

import com.clubee.domain.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Category")
@Table(name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryType name;

    @ManyToMany
    private List<CustomerModel> customerModels;

    public CategoryModel() {
    }

    public CategoryModel(Long id, CategoryType name) {
        this.id = id;
        this.name = name;
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
}
