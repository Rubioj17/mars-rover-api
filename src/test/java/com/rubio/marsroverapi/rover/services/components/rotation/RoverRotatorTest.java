package com.rubio.marsroverapi.rover.services.components.rotation;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoverRotatorTest {
    @InjectMocks
    RoverRotator rotator;
    @Mock
    Rover rover;

    @Test
    public void testRotateRight_WhenDirectionIsNorth() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.NORTH;
        RoverDirectionEnum expected = RoverDirectionEnum.EAST;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateRight(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateRight_WhenDirectionIsEast() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.EAST;
        RoverDirectionEnum expected = RoverDirectionEnum.SOUTH;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateRight(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateRight_WhenDirectionIsSouth() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.SOUTH;
        RoverDirectionEnum expected = RoverDirectionEnum.WEST;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateRight(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateRight_WhenDirectionIsWest() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.WEST;
        RoverDirectionEnum expected = RoverDirectionEnum.NORTH;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateRight(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateLeft_WhenDirectionIsNorth() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.NORTH;
        RoverDirectionEnum expected = RoverDirectionEnum.WEST;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateLeft(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateLeft_WhenDirectionIsWest() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.WEST;
        RoverDirectionEnum expected = RoverDirectionEnum.SOUTH;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateLeft(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateLeft_WhenDirectionIsSouth() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.SOUTH;
        RoverDirectionEnum expected = RoverDirectionEnum.EAST;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateLeft(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

    @Test
    public void testRotateLeft_WhenDirectionIsEast() {
        //Antes
        RoverDirectionEnum actual = RoverDirectionEnum.EAST;
        RoverDirectionEnum expected = RoverDirectionEnum.NORTH;

        //Entonces
        when(rover.getDirection()).thenReturn(actual);

        boolean result = rotator.rotateLeft(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setDirection(expected);
    }

}