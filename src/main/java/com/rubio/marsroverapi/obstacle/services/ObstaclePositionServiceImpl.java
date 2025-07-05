package com.rubio.marsroverapi.obstacle.services;

import com.rubio.marsroverapi.obstacle.models.Obstacle;
import com.rubio.marsroverapi.obstacle.repositories.ObstacleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        //Este for no me parece necesario, pienso que se puede
        //hacer una busqueda directa de la posicion y hacer el retorno
        //return repository.existsByPosXAndPosY(posX, posY);
        for (Obstacle obstacle : obstacleList) {
            if (posX == obstacle.getPosX() && posY == obstacle.getPosY()) {
                return true;
            }
        }
        return false;
    }
}
