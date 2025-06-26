package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.Rover;

public class TurnLeftCommand implements RoverCommand{
    private final RoverRotator roverRotator;

    public TurnLeftCommand(RoverRotator roverRotator) {
        this.roverRotator = roverRotator;
    }

    @Override
    public boolean execute(Rover rover) {
        return roverRotator.rotateLeft(rover);
    }
}
