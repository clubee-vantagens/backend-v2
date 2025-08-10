package com.clubee.domain.entity;

import com.clubee.domain.enums.Categories;
import com.clubee.domain.vo.*;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "Customer")
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "customer_id", updatable = false, nullable = false, unique = true)
  private UUID customerId;
  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "name", nullable = false))
  private Name name;
  @Embedded
  @AttributeOverride(name = "value", column = @Column(name = "social_name"))
  private Name socialName;
  @Embedded
  private Email email;
  @Embedded
  private CPF cpf;
  @Embedded
  private Password password;
  @Embedded
  private Phone phone;
  @Embedded
  private BirthDate birthDate;
  @Embedded
  private Address address;
  @ElementCollection(targetClass = Categories.class)
  @CollectionTable(
          name = "customer_categories",
          joinColumns = @JoinColumn(name = "customer_id")
  )
  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private Set<Categories> categories;

  public Customer() {

  }

  public UUID getCustomerId() {
    return customerId;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Name getSocialName() {
    return socialName;
  }

  public void setSocialName(Name socialName) {
    this.socialName = socialName;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public CPF getCpf() {
    return cpf;
  }

  public void setCpf(CPF cpf) {
    this.cpf = cpf;
  }

  public Password getPassword() {
    return password;
  }

  public void setPassword(Password password) {
    this.password = password;
  }

  public Phone getPhone() {
    return phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  public BirthDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(BirthDate birthDate) {
    this.birthDate = birthDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Set<Categories> getCategories() {
    return categories;
  }

  public void setCategories(Set<Categories> categories) {
    this.categories = categories;
  }
}
