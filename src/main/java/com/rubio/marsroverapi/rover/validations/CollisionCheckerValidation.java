package com.rubio.marsroverapi.rover.validations;

import com.rubio.marsroverapi.obstacle.services.ObstaclePositionService;
import org.springframework.stereotype.Component;

@Component
public class CollisionCheckerValidation implements RoverValidation {
    private final ObstaclePositionService obstaclePositionService;

    public CollisionCheckerValidation(ObstaclePositionService obstaclePositionService) {
        this.obstaclePositionService = obstaclePositionService;
    }
    @Override
    public boolean isOccupied(int posX, int posY) {
        return obstaclePositionService.isObstacleAt(posX, posY);
    }
}
