package com.clubee.domain.enums;

public enum States {
  AC("Acre"),
  AL("Alagoas"),
  AP("Amapá"),
  AM("Amazonas"),
  BA("Bahia"),
  CE("Ceará"),
  DF("Distrito Federal"),
  ES("Espírito Santo"),
  GO("Goiás"),
  MA("Maranhão"),
  MT("Mato Grosso"),
  MS("Mato Grosso do Sul"),
  MG("Minas Gerais"),
  PA("Pará"),
  PB("Paraíba"),
  PR("Paraná"),
  PE("Pernambuco"),
  PI("Piauí"),
  RJ("Rio de Janeiro"),
  RN("Rio Grande do Norte"),
  RS("Rio Grande do Sul"),
  RO("Rondônia"),
  RR("Roraima"),
  SC("Santa Catarina"),
  SP("São Paulo"),
  SE("Sergipe"),
  TO("Tocantins");

  private final String state;

  States(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public static States fromStatesName(String stateName) {
    for (States s : values()) {
      if (s.getState().equalsIgnoreCase(stateName)) {
        return s;
      }
    }
    throw new IllegalArgumentException("Invalid state");
  }
}
