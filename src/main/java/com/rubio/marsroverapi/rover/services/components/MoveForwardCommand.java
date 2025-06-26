package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.Rover;

public class MoveForwardCommand implements RoverCommand {
    private final RoverMover roverMover;

    public MoveForwardCommand(RoverMover roverMover) {
        this.roverMover = roverMover;
    }

    @Override
    public boolean execute(Rover rover) {
        return roverMover.moveForward(rover);
    }
}
