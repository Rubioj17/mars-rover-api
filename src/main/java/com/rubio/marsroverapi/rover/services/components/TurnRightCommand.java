package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.Rover;

public class TurnRightCommand implements RoverCommand {
    private final RoverRotator roverRotator;

    public TurnRightCommand(RoverRotator roverRotator) {
        this.roverRotator = roverRotator;
    }

    @Override
    public boolean execute(Rover rover) {
        return roverRotator.rotateRight(rover);
    }
}
