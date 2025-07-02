package com.rubio.marsroverapi.rover.dto;

import com.rubio.marsroverapi.rover.models.RoverDirectionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoverDto {
    private Integer posX;
    private Integer posY;
    private RoverDirectionEnum direction;
}
