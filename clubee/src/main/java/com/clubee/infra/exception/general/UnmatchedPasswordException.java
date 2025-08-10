package com.clubee.infra.exception.general;

public class UnmatchedPasswordException extends RuntimeException {

    public UnmatchedPasswordException(String message) {
        super(message);
    }
}
