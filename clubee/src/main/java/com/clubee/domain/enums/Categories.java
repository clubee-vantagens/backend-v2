package com.clubee.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Categories {
  ALIMENTACAO("Alimentação"),
  PETSHOP("PetShop"),
  PRODUTOS_ARTESANAIS("Produtos artesanais"),
  PAPELARIA("Papelaria"),
  FLORES_E_PLANTAS("Flores e plantas"),
  BELEZA_E_ESTETICA("Beleza e estética"),
  MANUTENCAO_AUTOMOVEIS("Manutenção de automóveis"),
  LIMPEZA_AUTOMOVEIS("Limpeza de automóveis"),
  LIVRARIA("Livraria"),
  PERFUMARIA("Perfumaria"),
  VESTUARIO_CALCADOS("Vestuário e calçados"),
  INFORMATICA_ELETRONICOS("Informática e eletrônicos");

  private final String category;

  Categories(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  @JsonCreator
  public static Categories fromValue(String value) {
    for (Categories c : Categories.values()) {
      if (c.category.equalsIgnoreCase(value)) {
        return c;
      }
    }
    throw new IllegalArgumentException("Invalid category: " + value);
  }
}
