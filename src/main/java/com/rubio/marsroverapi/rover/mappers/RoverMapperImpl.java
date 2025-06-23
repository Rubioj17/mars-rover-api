package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.models.Rover;

public class RoverMapperImpl implements RoverMapper {

    @Override
    public RoverDto toDto(Rover rover) {
        if (rover == null) return null;

        RoverDto dto = new RoverDto();
        dto.setPosX(rover.getPosX());
        dto.setPosY(rover.getPosY());

        return dto;
    }

    @Override
    public Rover toEntity(RoverDto roverDto) {
        if (roverDto == null) return null;

        Rover entity = new Rover();
        entity.setPosX(roverDto.getPosX());
        entity.setPosY(roverDto.getPosY());

        return entity;
    }

}
