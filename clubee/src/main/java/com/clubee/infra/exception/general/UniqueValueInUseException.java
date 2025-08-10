package com.clubee.infra.exception.general;

public class UniqueValueInUseException extends RuntimeException {
    public UniqueValueInUseException(String message) {
        super(message);
    }
}
