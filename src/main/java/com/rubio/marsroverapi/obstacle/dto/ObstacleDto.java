package com.rubio.marsroverapi.obstacle.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObstacleDto {
    @NotNull(message = "posX Required")
    private Integer posX;
    @NotNull(message = "posY Required")
    private Integer posY;
}
