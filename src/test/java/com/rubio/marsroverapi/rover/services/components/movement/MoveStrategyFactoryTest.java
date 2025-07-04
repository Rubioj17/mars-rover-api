package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MoveStrategyFactoryTest {
    @InjectMocks
    private MoveStrategyFactory factory;


    @Test
    public void testGetStrategy_WhenIsEast() {
        //Antes
        RoverDirectionEnum direction = RoverDirectionEnum.EAST;

        //Entonces
        MoveStrategy resultado = factory.getStrategy(direction);

        //Despues
        Assertions.assertInstanceOf(MoveEastStrategy.class, resultado);
    }

    @Test
    public void testGetStrategy_WhenIsWest() {
        //Antes
        RoverDirectionEnum direction = RoverDirectionEnum.WEST;

        //Entonces
        MoveStrategy resultado = factory.getStrategy(direction);

        //Despues
        Assertions.assertInstanceOf(MoveWestStrategy.class, resultado);
    }

    @Test
    public void testGetStrategy_WhenIsNorth() {
        //Antes
        RoverDirectionEnum direction = RoverDirectionEnum.NORTH;

        //Entonces
        MoveStrategy resultado = factory.getStrategy(direction);

        //Despues
        Assertions.assertInstanceOf(MoveNorthStrategy.class, resultado);
    }

    @Test
    public void testGetStrategy_WhenIsSouth() {
        //Antes
        RoverDirectionEnum direction = RoverDirectionEnum.SOUTH;

        //Entonces
        MoveStrategy resultado = factory.getStrategy(direction);

        //Despues
        Assertions.assertInstanceOf(MoveSouthStrategy.class, resultado);
    }

}