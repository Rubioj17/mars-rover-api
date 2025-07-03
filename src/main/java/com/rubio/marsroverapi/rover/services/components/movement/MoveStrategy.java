package com.rubio.marsroverapi.rover.services.components.movement;

import com.rubio.marsroverapi.rover.models.Rover;

public interface MoveStrategy {
    boolean move(Rover rover);
}
