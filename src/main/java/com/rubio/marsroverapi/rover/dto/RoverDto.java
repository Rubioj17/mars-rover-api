package com.rubio.marsroverapi.rover.dto;

import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import lombok.Data;

@Data
public class RoverDto {
    private Integer posX;
    private Integer posY;
    private RoverDirectionEnum direction;
}
