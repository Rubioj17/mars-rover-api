package com.rubio.marsroverapi.rover.services;

import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverPositionServiceImplTest {
    @InjectMocks
    private RoverPositionServiceImpl roverPositionService;
    @Mock
    private RoverRepository repository;

    @Test
    public void testIsRoverAt_WhenIsFalse() {
        //Antes
        int posX = 3;
        int posY = 4;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(false);
        boolean result = roverPositionService.isRoverAt(posX, posY);

        //Despues
        Assertions.assertFalse(result);
        verify(repository, times(1)).existsByPosXAndPosY(posX,posY);
    }

    @Test
    public void testIsRoverAt_WhenIsTrue() {
        //Antes
        int posX = 3;
        int posY = 4;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(true);
        boolean result = roverPositionService.isRoverAt(posX, posY);

        //Despues
        Assertions.assertTrue(result);
        verify(repository, times(1)).existsByPosXAndPosY(posX,posY);
    }

}