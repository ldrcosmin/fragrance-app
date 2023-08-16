package com.fragranceapp.fragranceapp.exceptions.userExceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
