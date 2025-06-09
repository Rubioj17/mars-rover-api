package com.rubio.marsroverapi.obstacle.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "obstacle")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer posX;
    private Integer posY;
}
