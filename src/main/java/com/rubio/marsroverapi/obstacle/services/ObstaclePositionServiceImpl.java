package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;

import java.util.List;

public class ObstaclePositionServiceImpl implements ObstaclePositionService {
    private final ObstacleRepository repository;

    public ObstaclePositionServiceImpl(ObstacleRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isObstacleAt(int posX, int posY) {
        //Tal vez seria buena idea no hacer esta consulta en cada momento
        // sino una vez y que la lista se gurde en memoria
        List<Obstacle> obstacleList = repository.findAll();
        for (Obstacle obstacle : obstacleList) {
            if (posX == obstacle.getPosX() && posY == obstacle.getPosY()) {
                return true;
            }
        }
        return false;
    }
}
