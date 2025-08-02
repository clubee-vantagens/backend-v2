package com.clubee.app.dto.response;

import java.util.UUID;

public record CustomerResponseDto(
        Long id,
        String name,
        String socialName,
        String email,
        String cpf
) {
}
