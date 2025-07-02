package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
        int posX = 2;
        int posY = 4;
        int[] idObstacles = {1, 2};
        int[] posObstacle1 = {2, 3};
        int[] posObstacle2 = {2, 4};

        Obstacle obstacle1 = new Obstacle(idObstacles[0], posObstacle1[0], posObstacle1[1]);
        Obstacle obstacle2 = new Obstacle(idObstacles[1], posObstacle2[0], posObstacle2[1]);
        List<Obstacle> obstacleList = List.of(obstacle1, obstacle2);

        //Entonces
        when(repository.findAll()).thenReturn(obstacleList);

        //Despues
        boolean result = obstaclePositionService.isObstacleAt(posX, posY);

        Assertions.assertTrue(result);

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testIsObstacleAt_WhenIsFalse() {
        //Antes
        int posX = 1;
        int posY = 1;
        int[] idObstacles = {1, 2};
        int[] posObstacle1 = {2, 3};
        int[] posObstacle2 = {4, 2};

        Obstacle obstacle1 = new Obstacle(idObstacles[0], posObstacle1[0], posObstacle1[1]);
        Obstacle obstacle2 = new Obstacle(idObstacles[1], posObstacle2[0], posObstacle2[1]);
        List<Obstacle> obstacleList = List.of(obstacle1, obstacle2);

        //Entonces
        when(repository.findAll()).thenReturn(obstacleList);

        //Despues
        boolean result = obstaclePositionService.isObstacleAt(posX, posY);

        Assertions.assertFalse(result);

        verify(repository, times(1)).findAll();
    }
}