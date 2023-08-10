package com.fragranceapp.fragranceapp.exceptions.userExceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
