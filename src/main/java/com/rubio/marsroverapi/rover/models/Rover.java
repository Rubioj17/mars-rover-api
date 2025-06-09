package com.rubio.marsroverapi.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rover")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer posX;
    private Integer posY;
    @Enumerated(EnumType.STRING)
    private RoverDirectionEnum direction;
}
