package com.clubee.app.dto.request;

import com.clubee.app.utils.ValidCpf;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDto(
        @NotBlank String name,
        @Nullable String socialName,
        @Email String email,
        @NotBlank @ValidCpf String cpf,
        @NotBlank @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
                message = "Senha segura (8-20 caracteres, 1 maiúscula, 1 número, 1 especial)") String password,
        @NotBlank @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
                message = "As senhas devem ser iguais") String passwordConfirmation
){
}
