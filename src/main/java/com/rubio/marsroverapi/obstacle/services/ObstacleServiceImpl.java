package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.mappers.ObstacleMapper;
import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import com.rubio.marsroverapi.obstacle.validations.ObstacleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObstacleServiceImpl implements ObstacleService {
    private final ObstacleRepository repository;
    private final ObstacleMapper obstacleMapper;
    private final List<ObstacleValidation> validationList;

    @Autowired
    public ObstacleServiceImpl(ObstacleRepository repository, ObstacleMapper obstacleMapper, List<ObstacleValidation> validationList) {
        this.repository = repository;
        this.obstacleMapper = obstacleMapper;
        this.validationList = validationList;
    }

    @Override
    public List<ObstacleDto> findAllObstacles() {
        List<Obstacle> obstacleList = repository.findAll();
        List<ObstacleDto> obstacleDtoList = new ArrayList<>();
        for (Obstacle obstacle : obstacleList) {
            obstacleDtoList.add(obstacleMapper.toDto(obstacle));
        }
        return obstacleDtoList;
    }

    @Override
    public ObstacleDto createObstacle(int posX, int posY) {
        for (ObstacleValidation validation : validationList) {
            validation.isValid(posX, posY);
        }

        Obstacle obstacle = new Obstacle();
        obstacle.setPosX(posX);
        obstacle.setPosY(posY);
        repository.save(obstacle);

        return obstacleMapper.toDto(obstacle);
    }

    @Override
    public String deleteAllObstacles() {
        repository.truncateTable();
        return "Deleted Successfully";
    }
}
