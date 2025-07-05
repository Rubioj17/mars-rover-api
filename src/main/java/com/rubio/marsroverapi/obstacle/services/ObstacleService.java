package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;

import java.util.List;

public interface ObstacleService {
    List<ObstacleDto> findAllObstacles();

    ObstacleDto createObstacle(int posX, int posY);

    String deleteAllObstacles();
}
