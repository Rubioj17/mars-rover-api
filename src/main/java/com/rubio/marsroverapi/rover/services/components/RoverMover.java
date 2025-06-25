package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.Rover;
import org.springframework.stereotype.Component;

@Component
public class RoverMover {

    public boolean moveForward(Rover rover) {
        return false;
    }

    public boolean move(Rover rover) {
        switch (rover.getDirection()) {
            case NORTH:
                return moveNorth(rover);
            case EAST:
                return moveEast(rover);
            case SOUTH:
                return moveSouth(rover);
            case WEST:
                return moveWest(rover);
        }
        return false;
    }

    private boolean moveNorth(Rover rover) {
        Integer posXRover = rover.getPosX();
        Integer posYRover = backward(rover.getPosY(), MapDimensions.height);
        if (collisionChecker.isOccupied(posXRover, posYRover)) {
            return true;
        }
        rover.setPosY(posYRover);
        return false;
    }

    private boolean moveSouth(Rover rover) {
        Integer posXRover = rover.getPosX();
        Integer posYRover = forward(rover.getPosY(), MapDimensions.height);
        if (collisionChecker.isOccupied(posXRover, posYRover)) {
            return true;
        }
        rover.setPosY(posYRover);
        return false;
    }

    private boolean moveEast(Rover rover) {
        Integer posXRover = forward(rover.getPosX(), MapDimensions.width);
        Integer posYRover = rover.getPosY();
        if (collisionChecker.isOccupied(posXRover, posYRover)) {
            return true;
        }
        rover.setPosX(posXRover);
        return false;
    }

    private boolean moveWest(Rover rover) {
        Integer posXRover = backward(rover.getPosX(), MapDimensions.width);
        Integer posYRover = rover.getPosY();
        if (collisionChecker.isOccupied(posXRover, posYRover)) {
            return true;
        }
        rover.setPosX(posXRover);
        return false;
    }
}
