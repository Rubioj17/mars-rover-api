package com.rubio.marsroverapi.obstacle.validations;

public class BoundsObstacleValidation implements ObstacleValidation {
    @Override
    public boolean isValid(int posX, int posY) {
        final int limitMapX = MapDimensions.width;
        final int limitMapY = MapDimensions.height;
        if ((posX < 0 || posY < 0 || posX >= limitMapX || posY >= limitMapY)) {
            throw new ObstacleCollisionException(
                    "Cannot create an obstacle outside the map (" + posX + ", " + posY + ")"
            );
        }
        return true;
    }
}
