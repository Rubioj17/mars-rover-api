package com.rubio.marsroverapi.obstacle.mappers;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.models.Obstacle;

public interface ObstacleMapper {

    ObstacleDto toDto(Obstacle obstacle);

    Obstacle toEntity(ObstacleDto obstacleDto);

}
