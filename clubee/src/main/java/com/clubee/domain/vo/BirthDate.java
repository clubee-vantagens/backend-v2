package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Embeddable
public class BirthDate {
  @Column(name = "birth_date", nullable = true)
  private LocalDate value;

  public BirthDate() {
  }

  public LocalDate getBirthDate() {
    return this.value;
  }

  public void setBirthDate(LocalDate birthDate) {
    if (birthDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Invalid birth date. Use the format dd/MM/yyyy and do not enter a future date");
    }
    this.value = LocalDate.parse(birthDate.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }
}
