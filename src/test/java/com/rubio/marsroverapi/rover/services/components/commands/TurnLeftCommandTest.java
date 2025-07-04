package com.rubio.marsroverapi.rover.services.components.commands;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.services.components.rotation.RoverRotator;
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
class TurnLeftCommandTest {
    @InjectMocks
    private TurnLeftCommand turnLeftCommand;
    @Mock
    private RoverRotator roverRotator;

    @Test
    public void testExecute_WhenIsFalse() {
        //Antes
        Rover rover = new Rover();

        //Entonces
        when(roverRotator.rotateLeft(rover)).thenReturn(false);
        boolean result = turnLeftCommand.execute(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(roverRotator).rotateLeft(rover);
    }

    @Test
    public void testExecute_WhenIsTrue() {
        //Antes
        Rover rover = new Rover();

        //Entonces
        when(roverRotator.rotateLeft(rover)).thenReturn(true);
        boolean result = turnLeftCommand.execute(rover);

        //Despues
        Assertions.assertTrue(result);
        verify(roverRotator).rotateLeft(rover);
    }

}