package com.rubio.marsroverapi.rover.mappers;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;
import com.rubio.marsroverapi.rover.models.Rover;
import org.springframework.stereotype.Component;

@Component
public class CommandResponseMapperImpl implements CommandResponseMapper {
    private final RoverMapper roverMapper;

    public CommandResponseMapperImpl(RoverMapper roverMapper) {
        this.roverMapper = roverMapper;
    }

    @Override
    public CommandResponseDto toDto(Rover rover, boolean isObstacleEncountered) {
        RoverDto roverDto = roverMapper.toDto(rover);
        CommandResponseDto commandResponseDto = new CommandResponseDto();

        commandResponseDto.setRoverDto(roverDto);
        commandResponseDto.setObstacleEncountered(isObstacleEncountered);

        return commandResponseDto;
    }

}
