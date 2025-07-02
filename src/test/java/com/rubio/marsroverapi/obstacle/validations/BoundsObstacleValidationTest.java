package com.rubio.marsroverapi.obstacle.validations;

import com.rubio.marsroverapi.shared.exceptions.ObstacleCollisionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BoundsObstacleValidationTest {
    @InjectMocks
    private BoundsObstacleValidation validation;

    @Test
    public void testIsValid_WhenIsNotValid() {
        //Verificar MapDimensions Width = 5 y Height = 5
        //Despues
        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(-1, 3)
        );

        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(3, -1)
        );

        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(5, 2)
        );

        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(2, 5)
        );

        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(6, 6)
        );
        Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(6, 6)
        );
    }

    @Test
    public void testIsValid_WhenIsValid() {
        //Verificar MapDimensions Width = 5 y Height = 5
        //Despues
        Assertions.assertDoesNotThrow(() -> validation.isValid(2, 2));

        Assertions.assertDoesNotThrow(() -> validation.isValid(0, 0));

        Assertions.assertDoesNotThrow(() -> validation.isValid(4, 4));

        Assertions.assertDoesNotThrow(() -> validation.isValid(2, 3));
    }

    @Test
    public void testIsValid_CorrectMessage() {
        //Verificar MapDimensions Width = 5 y Height = 5
        //Despues

        String expected = "Cannot create an obstacle outside the map (6, 6)";

        ObstacleCollisionException exception = Assertions.assertThrows(ObstacleCollisionException.class, () ->
                validation.isValid(6, 6)
        );

        Assertions.assertEquals(expected, exception.getMessage());
    }
}