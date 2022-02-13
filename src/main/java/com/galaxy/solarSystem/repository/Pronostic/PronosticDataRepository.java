package com.galaxy.solarSystem.repository.Pronostic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface PronosticDataRepository extends CrudRepository<PronosticData, String>, QueryByExampleExecutor<PronosticData> {

    @Query(value = "SELECT * FROM pronostics p WHERE p.day = :day", nativeQuery = true)
    PronosticData findByDay(@Param("day") int day);

    @Query(value = "SELECT * FROM pronostics p", nativeQuery = true)
    List<PronosticData> findAllPronostics();
}
