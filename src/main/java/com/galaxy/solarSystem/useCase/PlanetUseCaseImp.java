package com.galaxy.solarSystem.useCase;

import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.useCase.util.PlanetEnum;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PlanetUseCaseImp implements PlanetUseCase{

    private final PlanetRepository planetRepository;

    private List<Planet> planetsSave = new ArrayList<>();

    @Override
    public List<Planet> savePlanets() {

        String clockwise = "clockwise";
        String counterclockwise = "counterclockwise";

        Planet ferengi = new Planet(PlanetEnum.FERENGI, clockwise,500, 1);
        Planet betasoide = new Planet(PlanetEnum.BETASOIDE, clockwise,2000, 3);
        Planet vulcano = new Planet(PlanetEnum.VULCANO, counterclockwise, 1000, 5);

        List<Planet> planets = new ArrayList<>();
        planets.add(ferengi);
        planets.add(betasoide);
        planets.add(vulcano);

        try{
            planetsSave = planetRepository.addPlanets(planets);
        }catch (Exception e) {
            System.out.println(e);
        }

        return planetsSave;

    }
}
