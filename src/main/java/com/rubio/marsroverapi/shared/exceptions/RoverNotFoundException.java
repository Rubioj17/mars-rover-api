package com.rubio.marsroverapi.shared.exceptions;

public class RoverNotFoundException extends RuntimeException {
    public RoverNotFoundException(String message) {
        super(message);
    }
}
