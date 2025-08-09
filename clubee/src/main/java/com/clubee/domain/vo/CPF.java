package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CPF {
  @Column(name = "cpf", nullable = false, unique = true, length = 11)
  private String value;
  private static final int FACTOR_FIRST_DIGIT = 10;
  private static final int FACTOR_SECOND_DIGIT = 11;

  public CPF() {

  }

  public String getCPF() {
    return value;
  }

  public void setCPF(String cpf) {
    String cleanedCpf = removeNonDigits(cpf);
    if (!isValid(cleanedCpf)) {
      throw new IllegalArgumentException("Invalid CPF");
    }
    this.value = cleanedCpf;
  }

  private boolean isValid(String cpf) {
    if (cpf.length() != 11 || allDigitsAreEqual(cpf)) {
      return false;
    }

    int digit1 = calculateDigit(cpf, FACTOR_FIRST_DIGIT);
    int digit2 = calculateDigit(cpf, FACTOR_SECOND_DIGIT);

    String actualDigits = cpf.substring(9);
    String calculatedDigits = String.valueOf(digit1) + digit2;

    return actualDigits.equals(calculatedDigits);
  }

  private String removeNonDigits(String input) {
    return input.replaceAll("\\D", "");
  }

  private boolean allDigitsAreEqual(String cpf) {
    char first = cpf.charAt(0);
    for (int i = 1; i < cpf.length(); i++) {
      if (cpf.charAt(i) != first) {
        return false;
      }
    }
    return true;
  }

  private int calculateDigit(String cpf, int factor) {
    int total = 0;
    for (int i = 0; i < factor - 1; i++) {
      int digit = Character.getNumericValue(cpf.charAt(i));
      total += digit * (factor - i);
    }

    int remainder = total % 11;
    return (remainder < 2) ? 0 : 11 - remainder;
  }
}
