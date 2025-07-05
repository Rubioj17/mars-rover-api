package com.rubio.marsroverapi.rover.services;

import com.rubio.marsroverapi.rover.dto.RoverDto;
import com.rubio.marsroverapi.rover.dto.request.CommandRequestDto;
import com.rubio.marsroverapi.rover.dto.response.CommandResponseDto;

public interface RoverService {
    RoverDto findRover();

    CommandResponseDto setCommand(CommandRequestDto commandList);
}
