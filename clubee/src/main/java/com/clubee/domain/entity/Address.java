package com.clubee.domain.entity;

import com.clubee.app.dto.response.ViaCepResponseDto;
import com.clubee.domain.enums.States;

public class Address {
    private String cep;
    private String street;
    private String district;
    private String city;
    private String addressNumber;
    private String complement;
    private String contactPhone;
    private States states;

    public Address() {}

    public Address(String cep, String street, String district, String city, String addressNumber, String complement, String contactPhone, States states) {
        if (cep == null || cep.isEmpty()) throw new RuntimeException("CEP cannot be null or empty");
        if (states == null) throw new RuntimeException("State cannot be null");
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.contactPhone = contactPhone;
        this.states = states;
    }
    public void addFromViaCepRequest(ViaCepResponseDto dto) {
        this.street = dto.street();
        this.city = dto.city();
        this.district = dto.district();
        this.states = States.valueOf(dto.state());
    }

    public String getCep() { return this.cep;}

    public String getStreet() { return this.street;}

    public String getDistrict() { return this.district; }

    public String getCity() { return this.city; }

    public String getAddressNumber() { return this.addressNumber; }

    public String getComplement() { return this.complement; }

    public String getContactPhone() { return this.contactPhone; }

    public States getStates() { return this.states;}
}
