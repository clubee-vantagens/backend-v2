package com.clubee.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  private final String value;

  private Password(String hashedPassword) {
    this.value = hashedPassword;
  }

  public static Password create(String password) {
    if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
      throw new IllegalArgumentException("Invalid password format. Password must be 8-20 characters and contain at least one uppercase letter, one lowercase letter, one number, and one special character (e.g., @$!%*?&).");
    }
    String hashed = encoder.encode(password);
    return new Password(hashed);
  }

  public static Password restore(String hashedPassword) {
    return new Password(hashedPassword);
  }

  public String getPassword() {
    return this.value;
  }

  public boolean passwordMatches(String password) {
    return encoder.matches(password, this.value);
  }
}
