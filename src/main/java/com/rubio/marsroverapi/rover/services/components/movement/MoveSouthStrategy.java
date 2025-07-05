package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.validations.RoverValidation;
import com.rubio.marsroverapi.shared.utilities.MapDimensions;

import static com.rubio.marsroverapi.rover.utilities.CircularPosition.backward;
import static com.rubio.marsroverapi.rover.utilities.CircularPosition.forward;

public class MoveSouthStrategy implements MoveStrategy {
    private final RoverValidation roverValidation;

    public MoveSouthStrategy(RoverValidation roverValidation) {
        this.roverValidation = roverValidation;
    }

    @Override
    public boolean move(Rover rover) {
        Integer posXRover = rover.getPosX();
        Integer posYRover = forward(rover.getPosY(), MapDimensions.HEIGHT);

        if (roverValidation.isOccupied(posXRover, posYRover)) {
            return true;
        }

        rover.setPosY(posYRover);
        return false;
    }

}
