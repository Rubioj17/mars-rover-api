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
class TurnRightCommandTest {
    @InjectMocks
    private TurnRightCommand turnRightCommand;
    @Mock
    private RoverRotator roverRotator;

    @Test
    public void testExecute_WhenIsFalse() {
        //Antes
        Rover rover = new Rover();

        //Entonces
        when(roverRotator.rotateRight(rover)).thenReturn(false);
        boolean result = turnRightCommand.execute(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(roverRotator).rotateRight(rover);
    }

    @Test
    public void testExecute_WhenIsTrue() {
        //Antes
        Rover rover = new Rover();

        //Entonces
        when(roverRotator.rotateRight(rover)).thenReturn(true);
        boolean result = turnRightCommand.execute(rover);

        //Despues
        Assertions.assertTrue(result);
        verify(roverRotator).rotateRight(rover);
    }

}