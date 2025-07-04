package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoverMoverTest {
    @InjectMocks
    private RoverMover roverMover;
    @Mock
    private MoveStrategyFactory factory;
    @Mock
    private Rover rover;
    @Mock
    MoveStrategy moveStrategy;

    @Test
    public void testMoveForward_WhenIsFalse() {
        //Entonces
        when(rover.getDirection()).thenReturn(RoverDirectionEnum.NORTH);
        when(factory.getStrategy(rover.getDirection())).thenReturn(moveStrategy);
        when(moveStrategy.move(rover)).thenReturn(false);

        boolean result = roverMover.moveForward(rover);

        //Despues
        Assertions.assertFalse(result);
        verify(factory).getStrategy(rover.getDirection());
        verify(moveStrategy).move(rover);
    }

    @Test
    public void testMoveForward_WhenIsTrue() {
        //Entonces
        when(rover.getDirection()).thenReturn(RoverDirectionEnum.NORTH);
        when(factory.getStrategy(rover.getDirection())).thenReturn(moveStrategy);
        when(moveStrategy.move(rover)).thenReturn(true);

        boolean result = roverMover.moveForward(rover);

        //Despues
        Assertions.assertTrue(result);
        verify(factory).getStrategy(rover.getDirection());
        verify(moveStrategy).move(rover);
    }

}