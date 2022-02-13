package com.galaxy.solarSystem.repository.Planet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetData {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String directionRotation;

    private int sunDistance;

    private int angularVelocity;
}
