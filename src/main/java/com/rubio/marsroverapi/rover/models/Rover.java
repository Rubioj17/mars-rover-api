package com.rubio.marsroverapi.rover.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
