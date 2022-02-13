package com.galaxy.solarSystem.repository.Planet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PlanetRepositoryAdapter implements PlanetRepository {

    private final PlanetDataRepository planetDataRepository;
    private final ObjectMapper mapper;

    @Override
    public List<Planet> addPlanets(List<Planet> planets) {

        final List<PlanetData> planetsData = planets.stream()
                .map(planet -> mapper.convertValue(planet, PlanetData.class))
                .collect(Collectors.toList());

        List<PlanetData> planetsDataSave = new ArrayList<>();
        for (PlanetData planetData: planetsData){
            PlanetData planetDataSave = planetDataRepository.save(planetData);
            planetsDataSave.add(planetDataSave);
        }

        final List<Planet> planetsSave = planetsDataSave.stream()
                .map(planetDataSave -> mapper.convertValue(planetDataSave, Planet.class))
                .collect(Collectors.toList());

        return planetsSave;

    }

    @Override
    public List<Planet> getPlanets() {

        List<PlanetData> planetsDataSave = planetDataRepository.findAllPlanets();

        final List<Planet> planetsSave = planetsDataSave.stream()
                .map(planetDataSave -> mapper.convertValue(planetDataSave, Planet.class))
                .collect(Collectors.toList());

        return planetsSave;
    }
}
