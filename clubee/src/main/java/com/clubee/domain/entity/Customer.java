package com.clubee.domain.entity;

import java.util.Set;
import java.util.UUID;

public class Customer {

    private Long id;
    private String name;
    private String socialName;
    private String email;
    private String cpf;
    private String phoneNumber;
    private String dateOfBirth;
    private Address address;
    private Set<Category> preferences;
    private User user;

    public Customer() {
    }

    public Customer(Long id, String name, String socialName, String email, String cpf, String phoneNumber, String dateOfBirth, Address address, Set<Category> preferences) {
        this.id = id;
        this.name = name;
        this.socialName = socialName;
        this.email = email;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.preferences = preferences;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Category> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Category> preferences) {
        this.preferences = preferences;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
