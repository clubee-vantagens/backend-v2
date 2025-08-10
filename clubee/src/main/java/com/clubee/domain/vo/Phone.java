package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
  @Column(name = "phone", nullable = true, unique = true)
  private String value;

  public Phone() {
  }

  public String getPhone() {
    return this.value;
  }

  public void setPhone(String phone) {
    if (!phone.matches("^\\+?\\d{1,3}\\s?\\(\\d{2}\\)\\s?9?\\d{4}-\\d{4}$")) {
      throw new IllegalArgumentException("Invalid phone number. Use the international format, e.g., +55 (11) 99999-9999");
    }
    this.value = phone;
  }
}
