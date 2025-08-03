package com.clubee.domain.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthDate {
  private final LocalDate value;

  public BirthDate(LocalDate birthDate) {
    if (birthDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Invalid birth date. Use the format dd/MM/yyyy and do not enter a future date");
    }
    this.value = LocalDate.parse(birthDate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public LocalDate getBirthDate() {
    return this.value;
  }
}
