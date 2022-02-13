package com.galaxy.solarSystem.repository.Planet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface PlanetDataRepository extends CrudRepository<PlanetData, Long>, QueryByExampleExecutor<PlanetData> {

    @Query(value = "SELECT * FROM Planets p", nativeQuery = true)
    List<PlanetData> findAllPlanets();
}
