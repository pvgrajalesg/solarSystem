package com.galaxy.solarSystem.model.gateways;

import com.galaxy.solarSystem.model.Planet;

import java.util.List;

public interface PlanetRepository {

    List<Planet> addPlanets(List<Planet> planets);

    List<Planet> getPlanets();
}
