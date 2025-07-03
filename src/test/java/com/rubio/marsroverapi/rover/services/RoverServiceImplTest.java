package com.rubio.marsroverapi.rover.services;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.dto.request.CommandRequestDto;
import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;
import com.rubio.marsroverapi.rover.mappers.CommandResponseMapper;
import com.rubio.marsroverapi.rover.mappers.RoverMapper;
import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import com.rubio.marsroverapi.rover.services.components.executor.RoverCommandExecutor;
import com.rubio.marsroverapi.shared.exceptions.RoverNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverServiceImplTest {
    @InjectMocks
    private RoverServiceImpl service;
    @Mock
    private RoverRepository repository;
    @Mock
    private RoverMapper mapper;
    @Mock
    private CommandResponseMapper commandResponseMapper;
    @Mock
    private RoverCommandExecutor roverCommandExecutor;

    @Test
    public void testFindRover() {
        //Antes
        Rover rover = new Rover();
        RoverDto roverDto = new RoverDto();

        //Entonces
        when(repository.findById(1)).thenReturn(Optional.of(rover));
        when(mapper.toDto(rover)).thenReturn(roverDto);
        RoverDto result = service.findRover();

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertEquals(roverDto, result);

        verify(repository, times(1)).findById(1);
        verify(mapper, times(1)).toDto(rover);
    }

    @Test
    public void testFindRover_WhenNotFound() {
        //Antes
        Rover rover = new Rover();
        String expected = "Rover not found";

        //Entonces
        when(repository.findById(1)).thenReturn(Optional.empty());

        //Despues
        RoverNotFoundException exception = Assertions.assertThrows(RoverNotFoundException.class, ()->
                service.findRover()
        );
        Assertions.assertEquals(expected, exception.getMessage());

        verify(repository, times(1)).findById(1);
        verify(mapper, times(0)).toDto(rover);
    }

    @Test
    public void testSetCommand_WhenObstacleIsFalse() {
        //Antes
        Rover rover = new Rover();
        boolean obstacleEncountered = false;
        CommandRequestDto commandList = new CommandRequestDto();
        CommandResponseDto responseDto = new CommandResponseDto();

        //Entonces
        when(repository.findById(1)).thenReturn(Optional.of(rover));
        when(roverCommandExecutor.execute(rover, commandList)).thenReturn(obstacleEncountered);
        when(commandResponseMapper.toDto(rover, obstacleEncountered)).thenReturn(responseDto);
        CommandResponseDto result = service.setCommand(commandList);

        //Despues
        Assertions.assertNotNull(result);

        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(rover);
        verify(roverCommandExecutor, times(1)).execute(rover, commandList);
        verify(commandResponseMapper, times(1)).toDto(rover, obstacleEncountered);
    }

    @Test
    public void testSetCommand_WhenObstacleIsTrue() {
        //Antes
        Rover rover = new Rover();
        boolean obstacleEncountered = true;
        CommandRequestDto commandList = new CommandRequestDto();
        CommandResponseDto responseDto = new CommandResponseDto();

        //Entonces
        when(repository.findById(1)).thenReturn(Optional.of(rover));
        when(roverCommandExecutor.execute(rover, commandList)).thenReturn(obstacleEncountered);
        when(commandResponseMapper.toDto(rover, obstacleEncountered)).thenReturn(responseDto);
        CommandResponseDto result = service.setCommand(commandList);

        //Despues
        Assertions.assertNotNull(result);

        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(rover);
        verify(roverCommandExecutor, times(1)).execute(rover, commandList);
        verify(commandResponseMapper, times(1)).toDto(rover, obstacleEncountered);
    }

    @Test
    public void testSetCommand_WhenRoverNotFound() {
        //Antes
        Rover rover = new Rover();
        boolean obstacleEncountered = false;
        CommandRequestDto commandList = new CommandRequestDto();
        String expected = "Rover not found";

        //Entonces
        when(repository.findById(1)).thenReturn(Optional.empty());

        //Despues
        RoverNotFoundException exception = Assertions.assertThrows(RoverNotFoundException.class, () ->
                service.setCommand(commandList)
        );
        Assertions.assertEquals(expected, exception.getMessage());

        verify(repository, times(1)).findById(1);
        verify(repository, times(0)).save(rover);
        verify(roverCommandExecutor, times(0)).execute(rover, commandList);
        verify(commandResponseMapper, times(0)).toDto(rover, obstacleEncountered);
    }

}