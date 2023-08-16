package com.fragranceapp.fragranceapp.exceptions.userExceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
