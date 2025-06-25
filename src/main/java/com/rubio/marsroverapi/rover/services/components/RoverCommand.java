package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.models.Rover;

public interface RoverCommand {
    boolean execute(Rover rover);
}
