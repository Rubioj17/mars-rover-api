package com.rubio.marsroverapi.rover.dto.request;

import lombok.Data;

@Data
public class CommandRequestDto {
    private String[] commandList;
}
