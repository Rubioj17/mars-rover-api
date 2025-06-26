package com.rubio.marsroverapi.rover.services.components;

import com.rubio.marsroverapi.rover.dto.request.CommandRequestDto;
import com.rubio.marsroverapi.rover.models.Rover;
import org.springframework.stereotype.Service;

@Service
public class RoverCommandExecutor {
    private final CommandFactory factory;

    public RoverCommandExecutor(CommandFactory factory) {
        this.factory = factory;
    }
    public boolean execute(Rover rover, CommandRequestDto commandList) {
        boolean isObstacleEncountered = false;
        for (String code : commandList.getCommandList()) {
            RoverCommand command = factory.getCommand(code);
            isObstacleEncountered = command.execute(rover);

            if (isObstacleEncountered) {
                break;
            }
        }
        return isObstacleEncountered;
    }
}
