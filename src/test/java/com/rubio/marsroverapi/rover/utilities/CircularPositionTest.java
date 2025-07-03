package com.rubio.marsroverapi.rover.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CircularPositionTest {

    @Test
    public void testForward_WhenLimitFinal() {
        //Antes
        int length = 5;
        int currentPos = 4;

        //Entonces
        int expected = 0;
        int result = CircularPosition.forward(currentPos, length);

        //Despues
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testForward_WhenInitialLimit() {
        //Antes
        int length = 5;
        int currentPos = 0;

        //Entonces
        int expected = 1;
        int result = CircularPosition.forward(currentPos, length);

        //Despues
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBackward_WhenLimitFinal() {
        //Antes
        int length = 5;
        int currentPos = 4;

        //Entonces
        int expected = 3;
        int result = CircularPosition.backward(currentPos, length);

        //Despues
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBackward_WhenLimitInitial() {
        //Antes
        int length = 5;
        int currentPos = 0;

        //Entonces
        int expected = 4;
        int result = CircularPosition.backward(currentPos, length);

        //Despues
        Assertions.assertEquals(expected, result);
    }

}