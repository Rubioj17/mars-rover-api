package com.rubio.marsroverapi.rover.initializer;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import com.rubio.marsroverapi.shared.utilities.MapDimensions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RoverInitializer {
    private final RoverRepository repository;

    @Autowired
    public RoverInitializer(RoverRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void initRover() {
        if (repository.count() == 0) {
            Random random = new Random();
            int posX = random.nextInt(MapDimensions.WIDTH);
            int posY = random.nextInt(MapDimensions.HEIGHT);
            int directionIndex = random.nextInt(RoverDirectionEnum.values().length - 1);

            Rover rover = new Rover();
            rover.setPosX(posX);
            rover.setPosY(posY);
            rover.setDirection(RoverDirectionEnum.values()[directionIndex]);

            repository.save(rover);
        }
    }

}
