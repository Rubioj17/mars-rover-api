package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.mappers.ObstacleMapper;
import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import com.rubio.marsroverapi.obstacle.validations.ObstacleValidation;
import com.rubio.marsroverapi.shared.exceptions.ObstacleCollisionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObstacleServiceImplTest {
    @Mock
    private ObstacleRepository repository;
    @Mock
    private ObstacleMapper obstacleMapper;
    @Mock
    private ObstacleValidation validation1;
    @Mock
    private ObstacleValidation validation2;

    private ObstacleService service;

    @BeforeEach
    void setUp() {
        List<ObstacleValidation> validationList = List.of(validation1, validation2);
        service = new ObstacleServiceImpl(repository, obstacleMapper, validationList);
    }

    @Test
    public void testFindAllObstacles() {
        //Antes
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        List<Obstacle> obstacleList = List.of(obstacle1, obstacle2);

        ObstacleDto obstacleDto1 = new ObstacleDto();
        ObstacleDto obstacleDto2 = new ObstacleDto();

        //Entonces
        when(repository.findAll()).thenReturn(obstacleList);
        when(obstacleMapper.toDto(obstacle1)).thenReturn(obstacleDto1);
        when(obstacleMapper.toDto(obstacle2)).thenReturn(obstacleDto2);


        //Despues
        List<ObstacleDto> result = service.findAllObstacles();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(obstacleDto1, result.get(0));
        Assertions.assertEquals(obstacleDto2, result.get(1));

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindAllObstacles_WhenNotFound() {
        //Antes
        List<Obstacle> obstacleList = new ArrayList<>();

        //Entonces
        when(repository.findAll()).thenReturn(obstacleList);

        //Despues
        List<ObstacleDto> result = service.findAllObstacles();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateObstacle() {
        //Antes
        int posX = 2;
        int posY = 3;
        ObstacleDto obstacleDto = new ObstacleDto(posX, posY);

        //Entonces
        when(validation1.isValid(posX, posY)).thenReturn(true);
        when(validation2.isValid(posX, posY)).thenReturn(true);
        when(obstacleMapper.toDto(any(Obstacle.class))).thenReturn(obstacleDto);

        //Despues
        ObstacleDto result = service.createObstacle(posX, posY);

        Assertions.assertNotNull(result, "No paso las validaciones");
        Assertions.assertEquals(posX, result.getPosX(), "PosX Incorrecto");
        Assertions.assertEquals(posY, result.getPosY(), "PosY Incorrecto");

        verify(repository, times(1)).save(any(Obstacle.class));
    }

    @Test
    public void testCreateObstacle_WhenThrowObstacleCollisionException() {
        //Antes
        int posX = 4;
        int posY = 2;

        //Entonces
        doThrow(new ObstacleCollisionException("No Valid"))
                .when(validation1).isValid(posX, posY);

        //Despues
        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                service.createObstacle(posX, posY)
        );

        verify(repository, times(0)).save(any(Obstacle.class));
    }

    @Test
    public void deleteAllObstacles() {
        String result = service.deleteAllObstacles();
        String expected = "Deleted Successfully";

        Assertions.assertEquals(expected, result);

        verify(repository, times(1)).truncateTable();
    }
}