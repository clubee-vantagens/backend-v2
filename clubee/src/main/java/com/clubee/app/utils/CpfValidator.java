package com.clubee.app.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }
        return isValidCpf(cpf);
    }

    private boolean isValidCpf(String cpf) {
        int firstCheckDigit = calculateCheckDigit(cpf, 10, 9);
        int secondCheckDigit = calculateCheckDigit(cpf, 11, 10);

        return firstCheckDigit == (cpf.charAt(9) - '0') &&
                secondCheckDigit == (cpf.charAt(10) - '0');
    }

    private int calculateCheckDigit(String cpf, int initialWeight, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (cpf.charAt(i) - '0') * initialWeight--;
        }
        int checkDigit = 11 - (sum % 11);
        return checkDigit > 9 ? 0 : checkDigit;
    }
}
