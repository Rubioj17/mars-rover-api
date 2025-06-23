package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.models.Rover;

public interface RoverMapper {

    RoverDto toDto(Rover rover);

    Rover toEntity(RoverDto roverDto);

}
