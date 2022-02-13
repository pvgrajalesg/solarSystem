package com.galaxy.solarSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.solarSystem.model.Period;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.useCase.PlanetUseCase;
import com.galaxy.solarSystem.useCase.PronosticUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClimateController {

    @Autowired
    private PronosticUseCase pronosticUseCase;

    /**
     * EJ: http://localhost:PUERTO/api/generatePronostic/climateByDay?day=4
     * @param day dia del que se quiere consultar el clima
     * @return el clima del dia consultado
     */
    @GetMapping("/climateByDay")
    public Pronostic climatePronosticByDay(@RequestParam int day){
        Pronostic pronostic = pronosticUseCase.climateByDay(day);
        return pronostic;
    }

    /**
     * EJ: http://localhost:PUERTO/api/generatePronostic
     * @return cuantas veces se repetirá cada tipo de clima en 10 anios.
     */
    @GetMapping("/generatePronostic")
    public List<Period> generatePronostic(){

        List<Period> resultPeriodos = pronosticUseCase.generatePeriods();

        return resultPeriodos;
    }
}
