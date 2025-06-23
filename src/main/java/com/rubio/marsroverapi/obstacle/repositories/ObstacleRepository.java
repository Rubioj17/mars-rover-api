package com.rubio.marsroverapi.obstacle.repositories;

import com.rubio.marsroverapi.obstacle.models.Obstacle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ObstacleRepository extends JpaRepository<Obstacle, Integer> {
    boolean existsByPosXAndPosY(Integer posX, Integer posY);

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE obstacle", nativeQuery = true)
    void truncateTable();
}
