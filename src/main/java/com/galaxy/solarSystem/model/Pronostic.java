package com.galaxy.solarSystem.model;

import com.galaxy.solarSystem.useCase.util.ClimateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pronostic {

    private Long id;
    private int day;
    private String climate;
    private double perimeter;

    public Pronostic(int day, ClimateEnum climate) {
        this.day = day;
        this.climate = climate.toString();
    }

    public Pronostic(int day, ClimateEnum climate, double perimeter) {
        this.day = day;
        this.climate = climate.toString();
        this.perimeter = perimeter;
    }
}
