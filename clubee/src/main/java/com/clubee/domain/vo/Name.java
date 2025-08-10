package com.clubee.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
  @Column(name = "name", nullable = false)
  private String value;

  public Name() {
  }

  public String getName() {
    return this.value;
  }

  public void setName(String name) {
    if (!name.matches("^(?=.{3,}$)[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
      throw new IllegalArgumentException("Invalid name");
    }
    this.value = name;
  }
}
