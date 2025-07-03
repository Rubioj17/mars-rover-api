package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RoverMapperImplTest {
    @InjectMocks
    private RoverMapperImpl mapper;

    private int id;
    private int posX;
    private int posY;
    private RoverDirectionEnum direction;

    @BeforeEach
    public void setUp() {
        id = 1;
        posX = 3;
        posY = 2;
        direction = RoverDirectionEnum.NORTH;
    }

    @Test
    public void testToDto() {
        //Antes
        Rover rover = new Rover(id, posX, posY, direction);

        //Entonces
        RoverDto result = mapper.toDto(rover);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertEquals(posX, result.getPosX());
        Assertions.assertEquals(posY, result.getPosY());
        Assertions.assertEquals(direction, result.getDirection());
    }

    @Test
    public void testToDto_WhenIsNull() {
        //Antes
        Rover rover = null;

        //Entonces
        RoverDto result = mapper.toDto(rover);

        //Despues
        Assertions.assertNull(result);
    }

    @Test
    public void testToEntity() {
        //Antes
        RoverDto roverDto = new RoverDto(posX, posY, direction);

        //Entonces
        Rover result = mapper.toEntity(roverDto);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertEquals(posX, result.getPosX());
        Assertions.assertEquals(posY, result.getPosY());
        Assertions.assertEquals(direction, result.getDirection());
    }

    @Test
    public void testToEntity_WhenIsNull() {
        //Antes
        RoverDto roverDto = null;

        //Entonces
        Rover result = mapper.toEntity(roverDto);

        //Despues
        Assertions.assertNull(result);
    }

}