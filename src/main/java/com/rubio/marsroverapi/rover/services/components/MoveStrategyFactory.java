package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import com.rubio.marsroverapi.rover.validations.RoverValidation;
import org.springframework.stereotype.Component;

@Component
public class MoveStrategyFactory {
    private final RoverValidation roverValidation;

    public MoveStrategyFactory(RoverValidation roverValidation) {
        this.roverValidation = roverValidation;
    }

    public MoveStrategy getStrategy(RoverDirectionEnum direction) {
        return switch (direction) {
            case EAST -> new MoveEastStrategy(roverValidation);
            case WEST -> new MoveWestStrategy(roverValidation);
            case NORTH -> new MoveNorthStrategy(roverValidation);
            case SOUTH -> new MoveSouthStrategy(roverValidation);
        };
    }
}
