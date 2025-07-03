package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;
import com.rubio.marsroverapi.rover.models.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandResponseMapperImplTest {
    @InjectMocks
    private CommandResponseMapperImpl mapper;
    @Mock
    private RoverMapper roverMapper;

    @Test
    public void testToDto() {
        //Antes
        Rover rover = new Rover();
        RoverDto roverDto = new RoverDto();
        boolean isObstacleEncountered = false;

        //Entonces
        when(roverMapper.toDto(rover)).thenReturn(roverDto);
        CommandResponseDto result = mapper.toDto(rover, isObstacleEncountered);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isObstacleEncountered());
        Assertions.assertEquals(roverDto, result.getRoverDto());
    }

    @Test
    public void testToDto_WhenObstacleEncountered() {
        //Antes
        Rover rover = new Rover();
        RoverDto roverDto = new RoverDto();
        boolean isObstacleEncountered = true;

        //Entonces
        when(roverMapper.toDto(rover)).thenReturn(roverDto);
        CommandResponseDto result = mapper.toDto(rover, isObstacleEncountered);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isObstacleEncountered());
        Assertions.assertEquals(roverDto, result.getRoverDto());
    }

}