package com.rubio.marsroverapi.obstacle.validations;

import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import com.rubio.marsroverapi.rover.services.RoverPositionService;
import com.rubio.marsroverapi.shared.exceptions.ObstacleCollisionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OccupiedSpaceValidationTest {
    @InjectMocks
    OccupiedSpaceValidation validation;
    @Mock
    private ObstacleRepository repository;
    @Mock
    private RoverPositionService roverPositionService;

    @Test
    public void testIsValid_WhenObstacleExist() {
        //Antes
        int posX = 2;
        int posY = 3;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(true);
        when(roverPositionService.isRoverAt(posX, posY)).thenReturn(false);

        //Despues
        Assertions.assertThrows(ObstacleCollisionException.class, () ->
            validation.isValid(posX, posY)
        );

        verify(repository, times(1)).existsByPosXAndPosY(posX, posY);
        verify(roverPositionService, times(1)).isRoverAt(posX, posY);
    }

    @Test
    public void testIsValid_WhenRoverExist() {
        //Antes
        int posX = 2;
        int posY = 3;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(false);
        when(roverPositionService.isRoverAt(posX, posY)).thenReturn(true);

        //Despues
        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(posX, posY)
        );

        verify(repository, times(1)).existsByPosXAndPosY(posX, posY);
        verify(roverPositionService, times(1)).isRoverAt(posX, posY);
    }

    @Test
    public void testIsValid_WhenIsValid() {
        //Antes
        int posX = 2;
        int posY = 3;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(false);
        when(roverPositionService.isRoverAt(posX, posY)).thenReturn(false);

        //Despues
        Assertions.assertDoesNotThrow(() -> validation.isValid(posX, posY));

        verify(repository, times(1)).existsByPosXAndPosY(posX, posY);
        verify(roverPositionService, times(1)).isRoverAt(posX, posY);
    }

    @Test
    public void testIsValid_CorrectMessage() {
        //Antes
        int posX = 2;
        int posY = 3;

        //Entonces
        when(repository.existsByPosXAndPosY(posX, posY)).thenReturn(true);
        when(roverPositionService.isRoverAt(posX, posY)).thenReturn(true);

        //Despues
        String expected = "The coordinate (" + posX + ", " + posY + ") is already occupied";

        ObstacleCollisionException exception = Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(posX, posY)
        );

        Assertions.assertEquals(expected, exception.getMessage());

        verify(repository, times(1)).existsByPosXAndPosY(posX, posY);
        verify(roverPositionService, times(1)).isRoverAt(posX, posY);
    }
}