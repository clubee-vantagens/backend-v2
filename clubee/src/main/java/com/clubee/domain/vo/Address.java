package com.clubee.domain.vo;

import com.clubee.domain.enums.States;
import jakarta.persistence.*;

@Embeddable
@Access(AccessType.PROPERTY)
public class Address {
  @Column(nullable = true)
  private String address;
  @Column(nullable = true)
  private String city;
  @Column(nullable = true)
  private String cep;
  @Column(name = "states", nullable = true)
  @Enumerated(EnumType.STRING)
  private States state;

  public Address() {

  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCEP() {
    return this.cep;
  }

  public void setCEP(String cep) {
    if (cep != null && !cep.matches("^\\d{5}-?\\d{3}$")) {
      throw new IllegalArgumentException("Invalid CEP format");
    }
    this.cep = cep;
  }

  public String getState() {
    return this.state.getState();
  }

  public void setState(States state) {
    if (state == null) {
      throw new IllegalArgumentException("State cannot be null");
    }
    this.state = state;
  }
}
