package com.rubio.marsroverapi.rover.validations;

import com.rubio.marsroverapi.obstacle.services.ObstaclePositionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CollisionCheckerValidationTest {
    @InjectMocks
    CollisionCheckerValidation validation;
    @Mock
    ObstaclePositionService obstaclePositionService;

    @Test
    public void testIsOccupied_WhenIsFalse() {
        //Antes
        int posX = 2;
        int posY = 4;

        //Entonces
        when(obstaclePositionService.isObstacleAt(posX, posY)).thenReturn(false);

        //Despues
        boolean result = validation.isOccupied(posX, posY);
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsOccupied_WhenIsTrue() {
        //Antes
        int posX = 2;
        int posY = 4;

        //Entonces
        when(obstaclePositionService.isObstacleAt(posX, posY)).thenReturn(true);

        //Despues
        boolean result = validation.isOccupied(posX, posY);
        Assertions.assertTrue(result);
    }

}