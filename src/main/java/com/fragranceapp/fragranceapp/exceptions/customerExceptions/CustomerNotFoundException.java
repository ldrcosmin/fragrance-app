package com.fragranceapp.fragranceapp.exceptions.customerExceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
