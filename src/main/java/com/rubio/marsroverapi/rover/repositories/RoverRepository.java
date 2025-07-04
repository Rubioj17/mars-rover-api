package com.rubio.marsroverapi.rover.repositories;

import com.rubio.marsroverapi.rover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoverRepository extends JpaRepository<Rover, Integer> {
    boolean existsByPosXAndPosY(int posX, int posY);
}
