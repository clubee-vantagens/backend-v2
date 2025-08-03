package com.clubee.domain.entity;

import com.clubee.domain.enums.Categories;
import com.clubee.domain.enums.States;
import com.clubee.domain.vo.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Customer {
  private final UUID customerId;
  private Name name;
  private Name socialName;
  private Email email;
  private CPF cpf;
  private Password password;
  private Phone phone;
  private BirthDate birthDate;
  private Address address;
  private final Set<Categories> categories;

  public Customer(String name, String socialName, String email, String cpf, String password, String phone, LocalDate birthDate, String address, String state, String city, String cep) {
    this.customerId = UUID.randomUUID();
    this.name = new Name(name);
    this.socialName = (socialName != null && !socialName.isBlank()) ? new Name(socialName) : null;
    this.email = new Email(email);
    this.cpf = new CPF(cpf);
    this.password = Password.create(password);
    this.phone = new Phone(phone);
    this.birthDate = new BirthDate(birthDate);
    this.address = new Address(address, city, cep, States.fromStatesName(state));
    this.categories = new HashSet<>();
  }

  public Customer(String customerId, String name, String socialName, String email, String cpf, String password, String phone, LocalDate birthDate, String address, String state, String city, String cep) {
    this.customerId = UUID.fromString(customerId);
    this.name = new Name(name);
    this.socialName = (socialName != null && !socialName.isBlank()) ? new Name(socialName) : null;
    this.email = new Email(email);
    this.cpf = new CPF(cpf);
    this.password = Password.restore(password);
    this.phone = new Phone(phone);
    this.birthDate = new BirthDate(birthDate);
    this.address = new Address(address, city, cep, States.fromStatesName(state));
    this.categories = new HashSet<>();
  }

  public UUID getCustomerId() {
    return customerId;
  }

  public String getName() {
    return this.name.getName();
  }

  public void setName(String name) {
    this.name = new Name(name);
  }

  public String getSocialName() {
    return this.socialName != null ? this.socialName.getName() : null;
  }

  public void setSocialName(String socialName) {
    this.socialName = (socialName != null && !socialName.isBlank()) ? new Name(socialName) : null;
  }

  public String getEmail() {
    return this.email.getEmail();
  }

  public String getCPF() {
    return this.cpf.getCPF();
  }

  public boolean passwordMatches(String password) {
    return this.password.passwordMatches(password);
  }

  public void changePassword(String newPassword) {
    this.password = Password.create(newPassword);
  }

  public String getPhone() {
    return this.phone.getPhone();
  }

  public LocalDate getBirthDate() {
    return this.birthDate.getBirthDate();
  }

  public String getAddress() {
    return this.address.getAddress();
  }

  public String getCity() {
    return this.address.getCity();
  }

  public String getCEP() {
    return this.address.getCEP();
  }

  public String getState() {
    return this.address.getState();
  }

  public void addCategory(Categories category) {
    this.categories.add(category);
  }
}
