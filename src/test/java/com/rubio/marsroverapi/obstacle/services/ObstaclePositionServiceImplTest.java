package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObstaclePositionServiceImplTest {
    @Mock
    private ObstacleRepository repository;
    @InjectMocks
    private ObstaclePositionServiceImpl obstaclePositionService;

    @Test
    public void testIsObstacleAt_WhenIsTrue() {
        //Antes
        int posX = 3;
        int posY = 4;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(true);
        boolean result = obstaclePositionService.isObstacleAt(posX, posY);

        //Despues
        Assertions.assertTrue(result);
        verify(repository, times(1)).existsByPosXAndPosY(posX,posY);
    }

    @Test
    public void testIsObstacleAt_WhenIsFalse() {
        //Antes
        //Antes
        int posX = 3;
        int posY = 4;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(false);
        boolean result = obstaclePositionService.isObstacleAt(posX, posY);

        //Despues
        Assertions.assertFalse(result);
        verify(repository, times(1)).existsByPosXAndPosY(posX,posY);
    }
}