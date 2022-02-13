package com.galaxy.solarSystem.repository.Pronostic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.solarSystem.model.Planet;
import com.galaxy.solarSystem.model.gateways.PronosticRepository;
import com.galaxy.solarSystem.model.Pronostic;
import com.galaxy.solarSystem.repository.Planet.PlanetData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PronosticRepositoryAdapter implements PronosticRepository{

    private final PronosticDataRepository pronosticDataRepository;
    private final ObjectMapper mapper;

    @Override
    public List<Pronostic> findAllPronostic() {
        List<PronosticData> pronosticsData = pronosticDataRepository.findAllPronostics();

        final List<Pronostic> pronostics = pronosticsData.stream()
                .map(pronosticData -> mapper.convertValue(pronosticData, Pronostic.class))
                .collect(Collectors.toList());
        return pronostics;
    }

    @Override
    public Pronostic climateByDay(int day) {
        PronosticData pronosticData = pronosticDataRepository.findByDay(day);
        return mapper.convertValue(pronosticData, Pronostic.class);
    }

    @Override
    public Pronostic save(Pronostic pronostic) {
        PronosticData pronosticData = mapper.convertValue(pronostic, PronosticData.class);

        PronosticData pronosticDataSave = pronosticDataRepository.save(pronosticData);

        Pronostic pronosticSave = mapper.convertValue(pronosticDataSave, Pronostic.class);

        return pronosticSave;
    }

    @Override
    public List<Pronostic> getAllPronostic() {
        List<PronosticData> pronosticsData = pronosticDataRepository.findAllPronostics();

        final List<Pronostic> pronostics = pronosticsData.stream()
                .map(pronosticData -> mapper.convertValue(pronosticData, Pronostic.class))
                .collect(Collectors.toList());

        return pronostics;
    }
}
