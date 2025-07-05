package com.rubio.marsroverapi.rover.services.components.rotation;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import org.springframework.stereotype.Component;

import static com.rubio.marsroverapi.rover.utilities.CircularPosition.backward;
import static com.rubio.marsroverapi.rover.utilities.CircularPosition.forward;

@Component
public class RoverRotator {
    public boolean rotateRight(Rover rover) {
        int currentDirectionIndex = rover.getDirection().ordinal();
        int nextDirectionIndex = forward(currentDirectionIndex, RoverDirectionEnum.values().length);
        rover.setDirection(RoverDirectionEnum.values()[nextDirectionIndex]);
        return false;
    }

    public boolean rotateLeft(Rover rover) {
        int currentDirectionIndex = rover.getDirection().ordinal();
        int nextDirectionIndex = backward(currentDirectionIndex, RoverDirectionEnum.values().length);
        rover.setDirection(RoverDirectionEnum.values()[nextDirectionIndex]);
        return false;
    }

}
