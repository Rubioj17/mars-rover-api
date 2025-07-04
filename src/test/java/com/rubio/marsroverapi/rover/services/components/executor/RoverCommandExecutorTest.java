package com.rubio.marsroverapi.rover.services.components.executor;

import com.rubio.marsroverapi.rover.dto.request.CommandRequestDto;
import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.services.components.commands.CommandFactory;
import com.rubio.marsroverapi.rover.services.components.commands.RoverCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverCommandExecutorTest {
    @InjectMocks
    private RoverCommandExecutor roverCommandExecutor;
    @Mock
    private CommandFactory factory;
    @Mock
    private RoverCommand moveCommand;
    @Mock
    private RoverCommand rotateCommand;

    @Test
    public void testExecute_WhenObstacleEncounteredIsFalse() {
        //Antes
        Rover rover = new Rover();
        String[] code = {"M", "L"};
        CommandRequestDto commandList = new CommandRequestDto();
        commandList.setCommandList(code);

        //Entonces
        when(factory.getCommand("M")).thenReturn(moveCommand);
        when(factory.getCommand("L")).thenReturn(rotateCommand);
        when(moveCommand.execute(rover)).thenReturn(false);
        when(rotateCommand.execute(rover)).thenReturn(false);

        boolean result = roverCommandExecutor.execute(rover, commandList);

        //Despues
        Assertions.assertFalse(result);
        verify(factory, times(1)).getCommand("M");
        verify(factory, times(1)).getCommand("L");
        verify(moveCommand, times(1)).execute(rover);
        verify(rotateCommand, times(1)).execute(rover);
    }

    @Test
    public void testExecute_WhenObstacleEncounteredIsTrue() {
        //Antes
        Rover rover = new Rover();
        String[] code = {"M", "L"};
        CommandRequestDto commandList = new CommandRequestDto();
        commandList.setCommandList(code);

        //Entonces
        when(factory.getCommand("M")).thenReturn(moveCommand);
        when(moveCommand.execute(rover)).thenReturn(true);

        boolean result = roverCommandExecutor.execute(rover, commandList);

        //Despues
        Assertions.assertTrue(result);
        verify(factory, times(1)).getCommand("M");
        verify(factory, never()).getCommand("L");
        verify(moveCommand, times(1)).execute(rover);
    }

}