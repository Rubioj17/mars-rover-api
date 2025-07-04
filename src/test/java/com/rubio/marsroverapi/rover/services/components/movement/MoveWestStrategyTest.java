package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.validations.RoverValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoveWestStrategyTest {
    @InjectMocks
    private MoveWestStrategy moveStrategy;
    @Mock
    private RoverValidation roverValidation;
    @Mock
    private Rover rover;

    @Test
    public void testMove_WhenValidationIsFalse() {
        //Antes
        int posXBefore = 0;
        int posXAfter = 4; //Considerar la dimension del Mapa
        int posY = 2;

        //Entonces
        when(rover.getPosX()).thenReturn(posXBefore);
        when(rover.getPosY()).thenReturn(posY);
        when(roverValidation.isOccupied(posXAfter, posY)).thenReturn(false);
        boolean result = moveStrategy.move(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(rover).setPosX(posXAfter);
    }

    @Test
    public void testMove_WhenValidationIsTrue() {
        //Antes
        int posXBefore = 0;
        int posXAfter = 4; //Considerar la dimension del Mapa
        int posY = 2;

        //Entonces
        when(rover.getPosX()).thenReturn(posXBefore);
        when(rover.getPosY()).thenReturn(posY);
        when(roverValidation.isOccupied(posXAfter, posY)).thenReturn(true);
        boolean result = moveStrategy.move(rover);

        //Despues
        Assertions.assertTrue(result);
        verify(rover, never()).setPosX(posXAfter);
    }

}