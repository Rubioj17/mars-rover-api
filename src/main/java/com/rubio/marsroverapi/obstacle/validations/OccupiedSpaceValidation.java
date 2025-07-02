package com.rubio.marsroverapi.obstacle.validations;

import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import com.rubio.marsroverapi.rover.services.RoverPositionService;
import com.rubio.marsroverapi.shared.exceptions.ObstacleCollisionException;
import org.springframework.stereotype.Component;

@Component
public class OccupiedSpaceValidation implements ObstacleValidation {
    private final ObstacleRepository repository;
    private final RoverPositionService roverPositionService;

    public OccupiedSpaceValidation(ObstacleRepository repository, RoverPositionService roverPositionService) {
        this.repository = repository;
        this.roverPositionService = roverPositionService;
    }

    @Override
    public void isValid(int posX, int posY) {
        boolean obstaclePresent = repository.existsByPosXAndPosY(posX, posY);
        boolean roverPresent = roverPositionService.isRoverAt(posX, posY);
        if (obstaclePresent || roverPresent) {
            throw new ObstacleCollisionException(
                    "The coordinate (" + posX + ", " + posY + ") is already occupied"
            );
        }
    }
}
