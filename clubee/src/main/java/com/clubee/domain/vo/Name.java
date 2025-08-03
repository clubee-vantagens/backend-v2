package com.clubee.domain.vo;

public class Name {
  private final String value;

  public Name(String name) {
    if (!name.matches("^(?=.{3,}$)[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)+$")) {
      throw new IllegalArgumentException("Invalid name");
    }
    this.value = name;
  }

  public String getName() {
    return this.value;
  }
}
