package com.galaxy.solarSystem.useCase;

import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.useCase.util.ClimateEnum;
import com.galaxy.solarSystem.useCase.util.PlanetEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PlanetUseCase.class)
public class PlanetUseCaseTest {

    @Mock
    private PlanetRepository planetRepository;

    @InjectMocks
    private PlanetUseCaseImp planetUseCase;

    @Test
    public void savePlanetCorrectRequestTest(){

        String clockwise = "clockwise";
        String counterclockwise = "counterclockwise";

        Planet ferengi = new Planet(PlanetEnum.FERENGI, clockwise,500, 1);
        Planet betasoide = new Planet(PlanetEnum.BETASOIDE, clockwise,2000, 3);
        Planet vulcano = new Planet(PlanetEnum.VULCANO, counterclockwise, 1000, 5);

        List<Planet> planets = new ArrayList<>();
        planets.add(ferengi);
        planets.add(betasoide);
        planets.add(vulcano);

        Mockito.when(planetRepository.addPlanets(planets)).thenReturn(planets);
        List<Planet> planetsSave = planetUseCase.savePlanets();

        Assert.assertNotNull(planetsSave);

    }
}
