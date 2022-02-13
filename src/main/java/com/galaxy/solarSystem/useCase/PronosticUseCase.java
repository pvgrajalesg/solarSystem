package com.galaxy.solarSystem.useCase;

import com.galaxy.solarSystem.model.Period;
import com.galaxy.solarSystem.model.Pronostic;

import java.util.List;

public interface PronosticUseCase {

    Pronostic climateByDay(int day);
    List<Period> generatePeriods();
}
