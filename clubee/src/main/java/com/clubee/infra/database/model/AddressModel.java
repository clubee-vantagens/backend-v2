package com.clubee.infra.database.model;

import com.clubee.domain.enums.States;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String cep;

    @Column(name = "states", nullable = true)
    @Enumerated(EnumType.STRING)
    private States states;
}
