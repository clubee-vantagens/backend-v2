package com.clubee.domain.vo;

import com.clubee.domain.enums.States;

public class Address {
  private final String address;
  private final String city;
  private final String cep;
  private final States state;

  public Address(String address, String city, String cep, States state) {
    if (!cep.matches("^\\d{5}-?\\d{3}$")) {
      throw new IllegalArgumentException("Invalid CEP");
    }
    if (state == null) {
      throw new IllegalArgumentException("State to be not null");
    }
    this.address = address;
    this.city = city;
    this.cep = cep;
    this.state = state;
  }

  public String getAddress() {
    return this.address;
  }

  public String getCity() {
    return this.city;
  }

  public String getCEP() {
    return this.cep;
  }

  public String getState() {
    return this.state.getState();
  }
}
