package com.rubio.marsroverapi.rover.initializer;

import com.rubio.marsroverapi.rover.models.Rover;
import com.rubio.marsroverapi.rover.repositories.RoverRepository;
import com.rubio.marsroverapi.shared.utilities.MapDimensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverInitializerTest {
    @InjectMocks
    RoverInitializer roverInitializer;
    @Mock
    RoverRepository repository;

    @Test
    public void testInitRover_WhenDataBaseIsEmpty() {
        //Antes
        when(repository.count()).thenReturn(0L);

        //Entonces
        roverInitializer.initRover();

        //Despues
        verify(repository, times(1)).save(any(Rover.class));
    }

    @Test
    public void testInitRover_WhenDataBaseIsNotEmpty() {
        //Antes
        when(repository.count()).thenReturn(1L);

        //Entonces
        roverInitializer.initRover();

        //Despues
        verify(repository, never()).save(any(Rover.class));
    }

    @Test
    public void testInitRover_WhenRoverIsCreate() {
        //Antes
        when(repository.count()).thenReturn(0L);

        //Entonces
        roverInitializer.initRover();

        //Despues
        ArgumentCaptor<Rover> roverCaptor = ArgumentCaptor.forClass(Rover.class);
        verify(repository).save(roverCaptor.capture());

        Rover savedRover = roverCaptor.getValue();
        assertTrue(savedRover.getPosX() >= 0 && savedRover.getPosX() < MapDimensions.WIDTH);
        assertTrue(savedRover.getPosY() >= 0 && savedRover.getPosY() < MapDimensions.HEIGHT);
        assertNotNull(savedRover.getDirection());
    }

}