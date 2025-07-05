package com.rubio.marsroverapi.rover.services;

import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import org.springframework.stereotype.Service;

@Service
public class RoverPositionServiceImpl implements RoverPositionService {
    private final RoverRepository repository;

    public RoverPositionServiceImpl(RoverRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isRoverAt(int posX, int posY) {
        return repository.existsByPosXAndPosY(posX, posY);
    }

}
