package com.rubio.marsroverapi.rover.utilities;

public class CircularPosition {
    public static int forward(int current, int length) {
        return (current + 1) % length;
    }

    public static int backward(int current, int length) {
        return (current - 1 + length) % length;
    }
}
