package com.sabora.server.Exceptions;

public class IllegalUserType extends RuntimeException {
    public IllegalUserType(String userType) {
        super(String.format("Invalid user type: %s", userType));
    }
}
