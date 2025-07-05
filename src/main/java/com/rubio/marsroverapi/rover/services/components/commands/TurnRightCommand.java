package com.rubio.marsroverapi.rover.services.components.commands;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.services.components.rotation.RoverRotator;

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
