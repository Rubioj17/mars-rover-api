package com.rubio.marsroverapi.rover.services.components.commands;

import com.rubio.marsroverapi.rover.services.components.movement.RoverMover;
import com.rubio.marsroverapi.rover.services.components.rotation.RoverRotator;
import com.rubio.marsroverapi.shared.exceptions.InvalidCommandException;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private final RoverMover roverMover;
    private final RoverRotator roverRotator;

    public CommandFactory(RoverMover roverMover, RoverRotator roverRotator) {
        this.roverMover = roverMover;
        this.roverRotator = roverRotator;
    }

    public RoverCommand getCommand(String code) {
        return switch (code) {
            case "M" -> new MoveForwardCommand(roverMover);
            case "L" -> new TurnLeftCommand(roverRotator);
            case "R" -> new TurnRightCommand(roverRotator);
            default -> throw new InvalidCommandException("Invalid command: " + code);
        };
    }

}
