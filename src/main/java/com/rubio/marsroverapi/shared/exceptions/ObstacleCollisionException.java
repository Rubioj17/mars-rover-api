package com.rubio.marsroverapi.shared.exceptions;

public class ObstacleCollisionException extends RuntimeException {
    public ObstacleCollisionException(String message) {
        super(message);
    }
}
