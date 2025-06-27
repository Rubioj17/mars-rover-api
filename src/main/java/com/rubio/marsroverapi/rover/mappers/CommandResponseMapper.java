package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;
import com.rubio.marsroverapi.rover.models.Rover;

public interface CommandResponseMapper {
    CommandResponseDto toDto(Rover rover, boolean isObstacleEncountered);
}
