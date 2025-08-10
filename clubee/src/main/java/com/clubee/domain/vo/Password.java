package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Embeddable
public class Password {

//  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Column(name = "password", nullable = false)
  private String value;

  public Password() {
  }

  public String getPassword() {
    return this.value;
  }

  public void setPassword(String password) {
    if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d])[^\\s]{8,20}$")) {
      throw new IllegalArgumentException("Invalid password format. Password must be 8-20 characters and contain at least one uppercase letter, one lowercase letter, one number, and one special character (e.g., @$!%*?&).");
    }
//    this.value = encoder.encode(password);
    this.value = password;
  }

  public boolean passwordMatches(String password) {
//    return encoder.matches(password, this.value);
    return true;
  }
}
