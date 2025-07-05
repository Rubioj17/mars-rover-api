package com.rubio.marsroverapi.obstacle.validations;

import com.rubio.marsroverapi.shared.exceptions.ObstacleCollisionException;
import com.rubio.marsroverapi.shared.utilities.MapDimensions;
import org.springframework.stereotype.Component;

@Component
public class BoundsObstacleValidation implements ObstacleValidation {

    @Override
    public void isValid(int posX, int posY) {
        final int limitMapX = MapDimensions.WIDTH;
        final int limitMapY = MapDimensions.HEIGHT;

        if ((posX < 0 || posY < 0 || posX >= limitMapX || posY >= limitMapY)) {
            throw new ObstacleCollisionException(
                    "Cannot create an obstacle outside the map (" + posX + ", " + posY + ")"
            );
        }
    }

}
