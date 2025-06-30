package com.rubio.marsroverapi.rover.services;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.dto.request.CommandRequestDto;
import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;
import com.rubio.marsroverapi.rover.mappers.CommandResponseMapper;
import com.rubio.marsroverapi.rover.mappers.RoverMapper;
import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import com.rubio.marsroverapi.rover.services.components.RoverCommandExecutor;
import com.rubio.marsroverapi.shared.exceptions.RoverNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoverServiceImpl implements RoverService {
    private final RoverRepository repository;
    private final RoverMapper roverMapper;
    private final CommandResponseMapper commandResponseMapper;
    private final RoverCommandExecutor roverCommandExecutor;

    @Autowired
    public RoverServiceImpl(RoverRepository repository, RoverMapper roverMapper, CommandResponseMapper commandResponseMapper, RoverCommandExecutor roverCommandExecutor) {
        this.repository = repository;
        this.roverMapper = roverMapper;
        this.commandResponseMapper = commandResponseMapper;
        this.roverCommandExecutor = roverCommandExecutor;
    }

    @Override
    public RoverDto findRover() {
        Optional<Rover> rover = repository.findById(1);
        if (rover.isPresent()) {
            return roverMapper.toDto(rover.get());
        }
        throw new RoverNotFoundException(
                "Rover not found"
        );
    }

    @Override
    public CommandResponseDto setCommand(CommandRequestDto commandList) {
        Rover rover = repository.findById(1)
                .orElseThrow(() -> new RoverNotFoundException("Rover not found")
        );

        boolean obstacleEncountered = roverCommandExecutor.execute(rover, commandList);
        repository.save(rover);

        CommandResponseDto responseDto;
        responseDto = commandResponseMapper.toDto(rover, obstacleEncountered);

        return responseDto;
    }
}
