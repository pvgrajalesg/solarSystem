package com.galaxy.solarSystem.model;

import com.galaxy.solarSystem.useCase.util.PlanetEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = Planet.class)
public class PlanetTest {


    @Test
    public void positionByDayPlanetClockwise(){

        Planet ferengi = new Planet(PlanetEnum.FERENGI, "clockwise",500, 1);
        Point point = ferengi.positionByDay(1);

        Assertions.assertEquals(point.getX(), -0.02);
    }

    @Test
    public void positionByDayPlanetCounterclockwise(){

        Planet vulcano = new Planet(PlanetEnum.VULCANO, "counterclockwise", 1000, 5);
        Point point = vulcano.positionByDay(1);

        Assertions.assertEquals(point.getX(), -0.09);
    }
}
