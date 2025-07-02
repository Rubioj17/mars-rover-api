package com.rubio.marsroverapi.obstacle.mappers;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.models.Obstacle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ObstacleMapperImplTest {
    @InjectMocks
    ObstacleMapperImpl mapper;

    @Test
    public void testToDto() {
        //Antes
        int id = 1;
        int posX = 3;
        int posY = 2;
        Obstacle obstacle = new Obstacle(id, posX, posY);

        //Entonces
        ObstacleDto result = mapper.toDto(obstacle);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertEquals(posX, result.getPosX());
        Assertions.assertEquals(posY, result.getPosY());
    }

    @Test
    public void testToDto_WhenIsNull() {
        //Antes
        Obstacle obstacle = null;

        //Entonces
        ObstacleDto result = mapper.toDto(obstacle);

        //Despues
        Assertions.assertNull(result);
    }

    @Test
    public void testToEntity() {
        //Antes
        int posX = 3;
        int posY = 2;
        ObstacleDto obstacleDto = new ObstacleDto(posX, posY);

        //Entonces
        Obstacle result = mapper.toEntity(obstacleDto);

        //Despues
        Assertions.assertNotNull(result);
        Assertions.assertEquals(posX, result.getPosX());
        Assertions.assertEquals(posY, result.getPosY());
    }

    @Test
    public void testToEntity_WhenIsNull() {
        //Antes
        ObstacleDto obstacleDto = null;

        //Entonces
        Obstacle result = mapper.toEntity(obstacleDto);

        //Despues
        Assertions.assertNull(result);
    }
}