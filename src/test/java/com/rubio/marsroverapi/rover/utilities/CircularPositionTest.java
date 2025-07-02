package com.rubio.marsroverapi.rover.utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CircularPositionTest {

    @Test
    public void testForward() {
        //Antes
        int length = 5;
        int currentPos = 4;

        //Entonces
        int expected = 0;
        int result = CircularPosition.forward(currentPos, length);
        Assertions.assertEquals(expected, result);

        //Despues
    }

}