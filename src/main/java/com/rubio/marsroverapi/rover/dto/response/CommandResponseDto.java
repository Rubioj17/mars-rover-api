package com.rubio.marsroverapi.rover.dto.response;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import lombok.Data;

@Data
public class CommandResponseDto {
    private RoverDto roverDto;
    private boolean obstacleEncountered;
}
