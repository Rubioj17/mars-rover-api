package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.Rover;
import org.springframework.stereotype.Component;

@Component
public class RoverMover {
    private final MoveStrategyFactory strategyFactory;

    public RoverMover(MoveStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public boolean moveForward(Rover rover) {
        MoveStrategy moveStrategy = strategyFactory.getStrategy(rover.getDirection());
        return moveStrategy.move(rover);
    }

}