package com.rubio.marsroverapi.obstacle.controllers;

import com.rubio.marsroverapi.obstacle.dto.ObstacleDto;
import com.rubio.marsroverapi.obstacle.services.ObstacleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obstacle")
public class ObstacleController {
    private final ObstacleService service;

    @Autowired
    public ObstacleController(ObstacleService obstacleService) {
        this.service = obstacleService;
    }

    @GetMapping
    public ResponseEntity<List<ObstacleDto>> findAllObstacles() {
        return ResponseEntity.ok(service.findAllObstacles());
    }

    @PostMapping("/create")
    public ResponseEntity<ObstacleDto> createObstacle(@Valid @RequestBody ObstacleDto obstacleRequest) {
        ObstacleDto obstacleResponse = service.createObstacle(obstacleRequest.getPosX(), obstacleRequest.getPosY());
        return new ResponseEntity<>(obstacleResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllObstacles() {
        String responseMessage = service.deleteAllObstacles();
        return ResponseEntity.ok(responseMessage);
    }
}
