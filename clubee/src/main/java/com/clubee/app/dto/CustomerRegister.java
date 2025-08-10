package com.clubee.app.dto;

public class CustomerRegister {
  public record Request(String name, String socialName, String email, String cpf, String password, String passwordConfirmation) {}
}
