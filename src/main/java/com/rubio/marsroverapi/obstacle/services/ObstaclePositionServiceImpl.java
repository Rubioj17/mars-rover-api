package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import org.springframework.stereotype.Service;

@Service
public class ObstaclePositionServiceImpl implements ObstaclePositionService {
    private final ObstacleRepository repository;

    public ObstaclePositionServiceImpl(ObstacleRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isObstacleAt(int posX, int posY) {
        return repository.existsByPosXAndPosY(posX, posY);
    }
}
