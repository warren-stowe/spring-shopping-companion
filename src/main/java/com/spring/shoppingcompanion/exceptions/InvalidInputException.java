package com.spring.shoppingcompanion.exceptions;

public class InvalidInputException extends RuntimeException {

    private final int statusCode;

    public InvalidInputException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
