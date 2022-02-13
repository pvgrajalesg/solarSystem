package com.galaxy.solarSystem.model;

import com.galaxy.solarSystem.useCase.util.PlanetEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Planet {

    private Long id;
    private String name;
    private String directionRotation;
    private int sunDistance;
    private int angularVelocity;

    public Planet(PlanetEnum name, String directionRotation, int sunDistance, int angularVelocity) {
        this.name = name.toString();
        this.directionRotation = directionRotation;
        this.sunDistance = sunDistance;
        this.angularVelocity = angularVelocity;
    }

    public Point positionByDay(int day){
        // Angular position = direction rotación +- (velocidad angular * tiempo)
        double angularPositionGrades = 0;
        switch (directionRotation) {
            case "clockwise":
                angularPositionGrades = 360 - (this.angularVelocity * day);
                break;
            case "counterclockwise":
                angularPositionGrades = 0 - (this.angularVelocity * day);
                break;
            default:
                angularPositionGrades = 0 - (this.angularVelocity * day);
        }

        double angularPositionRad = Math.toRadians(angularPositionGrades);

        double x = Math.round(Math.sin(angularPositionRad)*100.0)/100.0;
        double y = Math.round(Math.cos(angularPositionRad)*100.0)/100.0;

        return new Point(x,y);
    }
}
