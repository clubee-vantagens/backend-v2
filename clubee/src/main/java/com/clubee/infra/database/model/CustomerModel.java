package com.clubee.infra.database.model;

import com.clubee.domain.enums.Categories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Customer")
@Table(name = "customers")
public class CustomerModel {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private UUID customerId;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false))
    private NameModel name;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "social_name"))
    private NameModel socialName;

    @Embedded
    private EmailModel email;

    @Embedded
    private CPFModel cpf;

    @Embedded
    private PasswordModel password;

    @Embedded
    private PhoneModel phone;

    @Embedded
    private BirthDateModel birth_date;

    @Embedded
    private AddressModel address;

    @ElementCollection(targetClass = Categories.class)
    @CollectionTable(
            name = "customer_categories",
            joinColumns = @JoinColumn(name = "customer_id")
    )
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Set<Categories> categories;
}
