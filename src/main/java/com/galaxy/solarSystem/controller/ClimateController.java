package com.galaxy.solarSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.solarSystem.controller.dto.PronosticDto;
import com.galaxy.solarSystem.model.Period;
import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.useCase.PlanetUseCase;
import com.galaxy.solarSystem.useCase.PronosticUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClimateController {

    @Autowired
    private PronosticUseCase pronosticUseCase;

    @Autowired
    private PlanetUseCase planetUseCase;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/climateByDay")
    public PronosticDto climatePronosticByDay(@RequestParam int day){
        Pronostic pronostic = pronosticUseCase.climateByDay(day);
        return mapper.convertValue(pronostic, PronosticDto.class);
    }

    @GetMapping("/generatePronostic")
    public List<Period> generatePronostic(){

        List<Period> resultPeriodos = new ArrayList<>();
        List<Planet> resultInsertPlanets = planetUseCase.savePlanets();
        if(!resultInsertPlanets.isEmpty()){
            resultPeriodos = pronosticUseCase.generatePeriods();
        }

        return resultPeriodos;
    }
}
