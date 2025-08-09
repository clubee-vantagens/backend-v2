package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
  @Column(name = "email", nullable = false, unique = true)
  private String value;

  public Email() {
  }

  public String getEmail() {
    return this.value;
  }

  public void setEmail(String email) {
    if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
      throw new IllegalArgumentException("Invalid email");
    }
    this.value = email;
  }
}
