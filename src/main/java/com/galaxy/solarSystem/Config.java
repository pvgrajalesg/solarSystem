package com.galaxy.solarSystem;

import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.model.gateways.PlanetRepository;
import com.galaxy.solarSystem.model.gateways.PronosticRepository;
import com.galaxy.solarSystem.useCase.PlanetUseCase;
import com.galaxy.solarSystem.useCase.PlanetUseCaseImp;
import com.galaxy.solarSystem.useCase.PronosticUseCase;
import com.galaxy.solarSystem.useCase.PronosticUseCaseImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static final int DAYS_YEARS = 360;
    private static final int YEARS_PRONOSTIC = 10;

    @Bean
    public PronosticUseCase createPronosticUseCase(PronosticRepository pronosticRepository, PlanetRepository planetRepository) {
        return new PronosticUseCaseImp(pronosticRepository, planetRepository);
    }

    @Bean
    public PlanetUseCase createPlanetUseCase(PlanetRepository repository) {

        return new PlanetUseCaseImp(repository);
    }

    @Bean
    public CommandLineRunner setup(PlanetUseCase planetUseCase, PronosticUseCase pronosticUseCase) {
        return (args) -> {

            try {
                planetUseCase.savePlanets();

                pronosticUseCase.getPronostics(3600);
            }catch (Exception e){
                throw new RuntimeException("No se pudieron guardar los datos de la BD");
            }

            logger.info("Los datos fueron cargados correctamente");
        };
    }
}
