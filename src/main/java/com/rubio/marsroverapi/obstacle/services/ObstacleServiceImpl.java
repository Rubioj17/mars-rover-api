package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObstacleServiceImpl implements ObstacleService {
    private final ObstacleRepository repository;

    @Autowired
    public ObstacleServiceImpl(ObstacleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ObstacleDto> findAllObstacles() {
        List<Obstacle> obstacleList = repository.findAll();
        List<ObstacleDto> obstacleDtoList = new ArrayList<>();
        return List.of();
    }

    @Override
    public ObstacleDto createObstacle(int posX, int posY) {
        return null;
    }

    @Override
    public String deleteAllObstacles() {
        return "";
    }
}
