package com.fragranceapp.fragranceapp.exceptions.orderExceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
