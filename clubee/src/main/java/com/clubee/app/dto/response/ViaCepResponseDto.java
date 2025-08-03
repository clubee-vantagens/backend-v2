package com.clubee.app.dto.response;

public record ViaCepResponseDto(
        String cep,
        String street,
        String district,
        String city,
        String state
) {
    public ViaCepResponseDto(Address address) {
        this(
                address.getCep(),
                address.getStreet(),
                address.getDistrict(),
                address.getCity(),
                address.getStates().name()
        );
    }
}
