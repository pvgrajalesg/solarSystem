package com.galaxy.solarSystem.model.gateways;

import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.Pronostic;

import java.util.List;

public interface PronosticRepository {
    public List<Pronostic> findAllPronostic();

    public Pronostic climateByDay(int day);

    Pronostic save(Pronostic pronostic);

    List<Pronostic> getAllPronostic();
}
