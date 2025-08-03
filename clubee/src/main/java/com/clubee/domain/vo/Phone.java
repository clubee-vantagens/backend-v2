package com.clubee.domain.vo;

public class Phone {
  private final String value;

  public Phone(String phone) {
    if (!phone.matches("^\\+?\\d{1,3}\\s?\\(\\d{2}\\)\\s?9?\\d{4}-\\d{4}$")) {
      throw new IllegalArgumentException("Invalid phone number. Use the international format, e.g., +55 (11) 99999-9999");
    }
    this.value = phone;
  }

  public String getPhone() {
    return this.value;
  }
}
