package com.galaxy.solarSystem.useCase;

import com.galaxy.solarSystem.model.Period;
import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.model.Point;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.model.gateways.PronosticRepository;
import com.galaxy.solarSystem.useCase.util.Calculation;
import com.galaxy.solarSystem.useCase.util.ClimateEnum;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PronosticUseCaseImp implements PronosticUseCase {

    private final PronosticRepository pronosticRepository;
    private final PlanetRepository planetRepository;

    private static final int DAYS_YEARS = 360;
    private static final int YEARS_PRONOSTIC = 10;

    @Override
    public Pronostic climateByDay(int day) {
        Pronostic pronosticByDay = pronosticRepository.climateByDay(day);
        return pronosticByDay;
    }

    @Override
    public List<Period> generatePeriods() {
        int daysNumber = YEARS_PRONOSTIC * DAYS_YEARS;
        List<Pronostic> pronostics = new ArrayList<>();

        getPronostics(daysNumber);

        pronostics = pronosticRepository.getAllPronostic();

        List<Period> periods = new ArrayList<>();
        long quantityPeriodsDrought = pronostics.stream().filter(pronostic -> ClimateEnum.DROUGHT.toString().equals(pronostic.getClimate())).count();
        Period period = new Period(ClimateEnum.DROUGHT, quantityPeriodsDrought);
        periods.add(period);

        long quantityPeriodsOptimun = pronostics.stream().filter(pronostic -> ClimateEnum.OPTIMUN.toString().equals(pronostic.getClimate())).count();
        period = new Period(ClimateEnum.OPTIMUN, quantityPeriodsOptimun);
        periods.add(period);

        long quantityPeriodsRainy = pronostics.stream().filter(pronostic -> ClimateEnum.RAINY.toString().equals(pronostic.getClimate())).count();
        period = new Period(ClimateEnum.RAINY, quantityPeriodsRainy);
        periods.add(period);

        return periods;
    }

    private List<Pronostic> getPronostics(int daysNumber) {
        List<Pronostic> pronostics = new ArrayList<>();
        for(int i=1; i<daysNumber; i++) {
            Pronostic pronostic = findPronosticByDay(i);
            pronostics.add(pronostic);
        }

        return pronostics;
    }

    private Pronostic findPronosticByDay(int day) {

        List<Planet> planets = planetRepository.getPlanets();

        List<Point> positionsPlanets = new ArrayList<>();

        for(Planet planet : planets){
            Point positionPlanet = planet.positionByDay(day);
            positionsPlanets.add(positionPlanet);
        }

        boolean isAlignedWithSun = Calculation.isAlignedWithSun(positionsPlanets);
        boolean  isAlignedWithoutSun = Calculation.isAlignedWithoutSun(positionsPlanets);
        boolean  isTriangle = Calculation.isTriangle(positionsPlanets, day);

        Pronostic pronostic = new Pronostic(day, ClimateEnum.UNKNOWN);

        if (isAlignedWithSun){
            pronostic = new Pronostic(day, ClimateEnum.DROUGHT);
        }else if(isAlignedWithoutSun){
            pronostic = new Pronostic(day, ClimateEnum.OPTIMUN);
        }else if(isTriangle){
            pronostic = new Pronostic(day, ClimateEnum.RAINY);
        }

        return pronosticRepository.save(pronostic);
    }

}
