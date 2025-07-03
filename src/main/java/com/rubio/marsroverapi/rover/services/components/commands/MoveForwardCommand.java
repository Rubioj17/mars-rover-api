package com.rubio.marsroverapi.rover.services.components.commands;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.services.components.movement.RoverMover;

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
