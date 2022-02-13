package com.galaxy.solarSystem;

import com.galaxy.solarSystem.controller.ClimateController;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.model.gateways.PronosticRepository;
import com.galaxy.solarSystem.useCase.PlanetUseCase;
import com.galaxy.solarSystem.useCase.PlanetUseCaseImp;
import com.galaxy.solarSystem.useCase.PronosticUseCase;
import com.galaxy.solarSystem.useCase.PronosticUseCaseImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SolarSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(SolarSystemApplication.class, args);
	}

}
