package com.rubio.marsroverapi.rover.services.components.commands;

import com.rubio.marsroverapi.rover.services.components.movement.RoverMover;
import com.rubio.marsroverapi.rover.services.components.rotation.RoverRotator;
import com.rubio.marsroverapi.shared.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommandFactoryTest {
    @InjectMocks
    private CommandFactory factory;
    @Mock
    private RoverMover roverMover;
    @Mock
    private RoverRotator roverRotator;

    @Test
    public void testGetCommand_WhenIsM() {
        //Antes
        String code = "M";

        //Entonces
        RoverCommand result = factory.getCommand(code);

        //Despues
        Assertions.assertInstanceOf(MoveForwardCommand.class, result);
    }

    @Test
    public void testGetCommand_WhenIsL() {
        //Antes
        String code = "L";

        //Entonces
        RoverCommand result = factory.getCommand(code);

        //Despues
        Assertions.assertInstanceOf(TurnLeftCommand.class, result);
    }

    @Test
    public void testGetCommand_WhenIsR() {
        //Antes
        String code = "R";

        //Entonces
        RoverCommand result = factory.getCommand(code);

        //Despues
        Assertions.assertInstanceOf(TurnRightCommand.class, result);
    }

    @Test
    public void testGetCommand_WhenIsInvalid() {
        //Antes
        String code = "X";
        String expected = "Invalid command: " + code;

        //Entonces
        InvalidCommandException exception = Assertions.assertThrows(InvalidCommandException.class, () ->
                factory.getCommand(code)
        );

        //Despues
        Assertions.assertEquals(expected, exception.getMessage());
    }

}